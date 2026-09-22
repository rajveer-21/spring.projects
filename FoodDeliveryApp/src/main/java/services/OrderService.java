package services;
import entities.*;
import dtos.*;
import exceptions.*;
import repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrderService
{
    private OrdersRepository ordersRepository;
    private MenuItemsRepository menuItemsRepository;
    private RestaurantRepository restaurantRepository;
    public OrderService(OrdersRepository ordersRepository, MenuItemsRepository menuItemsRepository, RestaurantRepository restaurantRepository)
    {
        this.ordersRepository = ordersRepository;
        this.menuItemsRepository = menuItemsRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @Transactional
    public OrderResponseDTO createOrder(CreateOrderRequestDTO request)
    {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurant_id()).orElseThrow(()-> new ResourceNotFoundException("Didn't find a restaurant with id - " + request.getRestaurant_id()));
        Order order = new Order();
        order.setCustomerAddress(request.getCustomer_address());
        order.setRestaurant(restaurant);
        Double totalAmount = 0.0;
        for(OrderItemRequestDTO items : request.getItems())
        {
            MenuItems menuitem = menuItemsRepository.findById(items.getMenuItemId()).orElseThrow(()-> new ResourceNotFoundException("Didn't find a menu item with id - " + items.getMenuItemId()));
            if(!menuitem.getRestaurant().getId().equals(order.getRestaurant().getId()))
            {
                throw new IllegalResourceException("Ordered item doesn't belong to this restaurant.");
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setMenuItem(menuitem);
            orderItem.setPrice(menuitem.getPrice() * items.getQuantity());
            orderItem.setQuantity(items.getQuantity());
            order.addItem(orderItem);
            totalAmount = totalAmount + orderItem.getPrice();
        }
        order.setTotalAmount(totalAmount);
        Order savedOrder = ordersRepository.save(order);
        return mapToDto(savedOrder);
    }
    @Transactional
    public OrderResponseDTO updateOrderStatus(Long orderId, OrderStatus newStatus)
    {
        Order order = ordersRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Couldn't find the required order with id - " + orderId));
        if(!order.getOrderStatus().canTransitionTo(newStatus))
            throw new InvalidOrderException("Can't transisition to this state.");
        order.setOrderStatus(newStatus);
        Order updatedOrder = ordersRepository.save(order);
        return mapToDto(updatedOrder);
    }
    @Transactional
    private OrderResponseDTO getOrderById(Long orderId)
    {
        Order order = ordersRepository.findById(orderId).orElseThrow(()-> new ResourceNotFoundException("Order couldn't be found with this id - " + orderId));
        return mapToDto(order);
    }
    private OrderResponseDTO mapToDto(Order order)
    {
        return new OrderResponseDTO(order.getOrderTime(), order.getId(), order.getCustomerAddress(), order.getRestaurant().getId(), order.getOrderStatus(), order.getTotalAmount());
    }
}
