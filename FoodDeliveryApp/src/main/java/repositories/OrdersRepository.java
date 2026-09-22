package repositories;
import entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrdersRepository extends JpaRepository<Order, Long>{
}
