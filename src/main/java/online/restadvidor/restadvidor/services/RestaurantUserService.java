package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RestaurantUserRepository;
import online.restadvidor.restadvidor.model.RestaurantUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantUserService implements CrudRestaurant<RestaurantUser, Long> {

    @Autowired
    RestaurantUserRepository restaurantUserRepository;

    @Override
    public List<RestaurantUser> getAll() {
        return restaurantUserRepository.findAll();
    }

    @Override
    public RestaurantUser save(RestaurantUser entity) {
        return restaurantUserRepository.save(entity);
    }

    @Override
    public void update(RestaurantUser entity, Long id) {
        if(id.intValue() >0 ){
            restaurantUserRepository.save(entity);
        }
    }

    @Override
    public void delete(RestaurantUser entity) {
        restaurantUserRepository.delete(entity);
    }

    @Override
    public RestaurantUser get(long id) {
        return restaurantUserRepository.findById(id).get();
    }
    
    public Optional<RestaurantUser> findByUsername(String username){
    	return restaurantUserRepository.findByUsername(username);
    }
    
    public Optional<RestaurantUser> findByEmail(String email){
    	return restaurantUserRepository.findByEmail(email);
    }

	public Boolean existsByUsername(String username) {
		return restaurantUserRepository.existsByUsername(username);
	}

	public Boolean existsByEmail(String email) {
		return restaurantUserRepository.existsByEmail(email);
	}
}