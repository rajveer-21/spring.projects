package repositories;
import entities.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MenuItemsRepository extends JpaRepository<MenuItems, Long>{
}
