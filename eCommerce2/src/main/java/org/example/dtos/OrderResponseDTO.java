package org.example.dtos;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
public class OrderResponseDTO
{
    private Long customerId;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private Long orderId;

    public OrderResponseDTO(Long customerId, LocalDateTime orderDate, Double totalAmount, Long orderId)
    {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderId = orderId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
