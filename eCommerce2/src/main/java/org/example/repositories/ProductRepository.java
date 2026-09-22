package org.example.repositories;
import org.example.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long>{
}
