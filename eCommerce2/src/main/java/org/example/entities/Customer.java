package org.example.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "CUSTOMERS")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String mail;

    public Customer(){}
    public Customer(String name, String mail)
    {
        this.name = name;
        this.mail = mail;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getMail()
    {
        return mail;
    }
}
