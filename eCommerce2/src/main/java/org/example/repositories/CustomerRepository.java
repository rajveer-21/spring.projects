package org.example.repositories;
import org.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
