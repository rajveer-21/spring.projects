package org.example.repositories;
import org.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Order, Long>
{
}
