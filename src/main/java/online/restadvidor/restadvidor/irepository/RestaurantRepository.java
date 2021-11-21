package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
