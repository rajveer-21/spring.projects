package org.example.servicesandcontrollers;
import org.example.entities.*;
import org.example.dtos.*;
import org.example.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.InsufficientResourcesException;

@Service
public class OrderService
{
    private CustomerRepository customerRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    OrderService(CustomerRepository customerRepository, OrderRepository orderRepository, ProductRepository productRepository)
    {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO)
    {
        Customer customer = customerRepository.findById(orderRequestDTO.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer Not Found with id - " + orderRequestDTO.getCustomerId()));
        Order order = new Order();
        order.setCustomer(customer);
        double totalAmount = 0.0;
        for(OrderItemRequestDTO item : orderRequestDTO.getItems())
        {
            Product product = productRepository.findById(item.getId()).orElseThrow(()-> new ResourceNotFoundException("Product Not Found with id - " + item.getProduct()));
            if(product.getStockQuantity() < item.getQuantity())
                throw new InsufficientResourcesException("Product quantity required is greater than stock! Decrease it.");
            product.setStockQuantity(product.getStockQuantity() - item.getQuantity());
            productRepository.save(product);
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(product.getPrice() * item.getQuantity());
            order.addOrderItem(orderItem);
            totalAmount = totalAmount + orderItem.getPrice();
        }
        order.setTotalAmount(totalAmount);
        Order ordered = orderRepository.save(order);
        return new OrderResponseDTO(customer.getId(), order.getOrderTime(), order.getTotalAmount(), order.getId());
    }
}
