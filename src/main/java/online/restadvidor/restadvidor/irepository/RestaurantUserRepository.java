package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantUserRepository extends JpaRepository<RestaurantUser, Long> {
}
