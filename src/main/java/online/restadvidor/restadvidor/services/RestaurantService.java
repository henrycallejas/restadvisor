package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RestaurantRepository;
import online.restadvidor.restadvidor.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService implements CrudRestaurant<Restaurant, Long> {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant save(Restaurant entity) {
        return restaurantRepository.save(entity);
    }

    @Override
    public void update(Restaurant entity, Long id) {
        if(id.intValue() >0){
            restaurantRepository.save(entity);
        }
    }

    @Override
    public void delete(Restaurant entity) {
        restaurantRepository.delete(entity);
    }

    @Override
    public Restaurant get(long id) {
        return restaurantRepository.findById(id).get();
    }
}