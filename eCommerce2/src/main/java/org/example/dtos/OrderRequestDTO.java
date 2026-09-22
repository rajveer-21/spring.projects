package org.example.dtos;
import org.example.entities.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.Valid;
import java.util.List;
public class OrderRequestDTO
{
    @NotNull(message = "Customer id must not be null.")
    private Long customerId;
    @NotEmpty(message = "Must contain some order items.")
    @Valid
    List<OrderItemRequestDTO> items;

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setItems(List<OrderItemRequestDTO> items) {
        this.items = items;
    }
    public List<OrderItemRequestDTO> getItems() {
        return items;
    }
}
