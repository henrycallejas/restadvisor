package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.RestaurantUser;
import online.restadvidor.restadvidor.services.RestaurantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    RestaurantUserService service;

    @GetMapping("/all")
    public List<RestaurantUser> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RestaurantUser getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody RestaurantUser user){
        service.save(user);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody RestaurantUser user, @PathVariable long id){
        service.update(user, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody RestaurantUser user){
        service.delete(user);
    }
}