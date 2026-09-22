package dtos;
import entities.*;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.ArrayList;
public class CreateOrderRequestDTO
{
    @NotNull(message = "Restaurant ID is needed.")
    private Long restaurant_id;
    @NotBlank(message = "Customer address is needed.")
    private String customer_address;
    @NotEmpty(message = "Some order items are needed to create an order.")
    private List<OrderItemRequestDTO> items;

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public List<OrderItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequestDTO> items) {
        this.items = items;
    }
}
