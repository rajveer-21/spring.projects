package org.example.servicesandcontrollers;
import org.example.entities.*;
import org.example.repositories.*;
import org.example.dtos.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController
{
    public final OrderService orderService;
    OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO request)
    {
        OrderResponseDTO response = orderService.createOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
