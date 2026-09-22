package entities;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "restaurant")
    private List<MenuItems> menuItems = new ArrayList<>();

    public Restaurant(){}
    public Restaurant(String name, String address)
    {
        this.name = name;
        this.address = address;
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

    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public List<MenuItems> getMenuItems()
    {
        return menuItems;
    }
    public void setMenuItems(List<MenuItems> menuItems)
    {
        this.menuItems = menuItems;
    }
}
