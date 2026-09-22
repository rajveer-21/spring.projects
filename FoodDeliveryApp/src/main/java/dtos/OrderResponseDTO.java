package dtos;
import entities.*;
import java.time.LocalDateTime;
public class OrderResponseDTO
{
    private LocalDateTime orderTime;
    private Long orderId;
    private String customerAddress;
    private Long restaurantId;
    private OrderStatus orderStatus;
    private Double totalAmount;

    public OrderResponseDTO(LocalDateTime orderTime, Long orderId, String customerAddress, Long restaurantId, OrderStatus orderStatus, Double totalAmount)
    {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.customerAddress = customerAddress;
        this.restaurantId = restaurantId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }
}
