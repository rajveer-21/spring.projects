package dtos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
public class OrderItemRequestDTO
{
    @NotNull(message = "Menu Item ID is needed.")
    private Long menuItemId;
    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity to be atleast 1.")
    private Integer quantity;

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
