package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.RestaurantUser;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantUserRepository extends JpaRepository<RestaurantUser, Long> {
	public Optional<RestaurantUser> findByUsername(String username);

	public Boolean existsByUsername(String username);
	
	public Optional<RestaurantUser> findByEmail(String email);

	public Boolean existsByEmail(String email);
	
	public RestaurantUser findByConfirm(String confirm);
	
}
