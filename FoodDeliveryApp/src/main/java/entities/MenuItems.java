package entities;
import jakarta.persistence.*;
@Entity
@Table(name = "MENUITEMS")
public class MenuItems
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    public MenuItems(){}
    public MenuItems(String name, Double price, Restaurant restaurant)
    {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Double getPrice()
    {
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
    public Restaurant getRestaurant()
    {
        return restaurant;
    }
    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}
