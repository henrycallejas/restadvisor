package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RestaurantUserRepository;
import online.restadvidor.restadvidor.model.RestaurantUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}