package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.Rol;
import online.restadvidor.restadvidor.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rols")
public class RolController {

    @Autowired
    RolService service;

    @GetMapping("/all")
    public List<Rol> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Rol getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Rol rol){
        service.save(rol);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Rol rol, @PathVariable long id){
        service.update(rol, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Rol rol){
        service.delete(rol);
    }

}