package dtos;
import entities.*;
import jakarta.validation.constraints.NotNull;
public class UpdateStatusRequestDTO
{
    @NotNull(message = "Order status is needed.")
    private OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
