package org.example.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "ORDERITEMS")
public class OrderItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    private Integer quantity;
    private Double price;

    public OrderItem(){}
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public Product getProduct()
    {
        return product;
    }
    public void setProduct(Product product)
    {
        this.product = product;
    }
    public Order getOrder()
    {
        return order;
    }
    public void setOrder(Order order)
    {
        this.order = order;
    }
    public Integer getQuantity()
    {
        return quantity;
    }
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
}
