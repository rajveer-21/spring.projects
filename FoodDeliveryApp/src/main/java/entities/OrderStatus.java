package entities;

public enum OrderStatus
{
    PENDING,
    CONFIRMED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED;
    public Boolean canTransitionTo(OrderStatus nextStatus)
    {
        if(this == CANCELLED || this == DELIVERED)
            return false;
        switch(this)
        {
            case PENDING:
                return nextStatus == CONFIRMED || nextStatus == CANCELLED;
            case CONFIRMED:
                return nextStatus == PREPARING || nextStatus == CANCELLED;
            case PREPARING:
                return nextStatus == OUT_FOR_DELIVERY;
            case OUT_FOR_DELIVERY:
                return nextStatus == DELIVERED;
            default:
                return false;
        }
    }
}
