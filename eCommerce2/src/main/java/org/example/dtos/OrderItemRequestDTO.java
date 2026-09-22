package org.example.dtos;
import org.example.entities.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemRequestDTO
{
    @NotNull(message = "Product ID must be non null.")
    private Long productId;
    @NotNull(message = "Must specify a quantity.")
    @Min(value = 1, message = "Minimum quantity should atleast be 1.")
    private Integer quantity;

    public Long getProductId()
    {
        return productId;
    }
    public void setProductId(Long productId)
    {
        this.productId = productId;
    }
    public Integer getQuantity()
    {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
