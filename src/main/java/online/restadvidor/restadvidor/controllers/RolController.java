package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.Role;
import online.restadvidor.restadvidor.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("rols")
public class RolController {

    @Autowired
    RolService service;

    @GetMapping("/all")
    public List<Role> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Role role){
        service.save(role);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Role role, @PathVariable long id){
        service.update(role, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Role role){
        service.delete(role);
    }

}