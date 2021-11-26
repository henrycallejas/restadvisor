package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.Restaurant;
import online.restadvidor.restadvidor.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @GetMapping("/all")
    public List<Restaurant> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Restaurant getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Restaurant restaurant){
        service.save(restaurant);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Restaurant restaurant, @PathVariable long id){
        service.update(restaurant, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Restaurant restaurant){
        service.delete(restaurant);
    }

}