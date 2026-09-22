package org.example.entities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name = "ORDERS")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    private Double totalAmount;
    private LocalDateTime orderTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order()
    {
        this.orderTime = LocalDateTime.now();
    }
    public Order(Customer customer, Double totalAmount, List<OrderItem> orderItems)
    {
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
    }
    public void addOrderItem(OrderItem orderItem)
    {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public Double getTotalAmount()
    {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    public LocalDateTime getOrderTime()
    {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime)
    {
        this.orderTime = orderTime;
    }
    public List<OrderItem> getOrderItems()
    {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems)
    {
        this.orderItems = orderItems;
    }
}
