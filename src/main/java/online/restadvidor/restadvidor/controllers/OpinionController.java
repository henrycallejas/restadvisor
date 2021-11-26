package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.Opinion;
import online.restadvidor.restadvidor.services.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("opinions")
public class OpinionController {

    @Autowired
    OpinionService service;

    @GetMapping("/all")
    public List<Opinion> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Opinion getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Opinion opinion){
        service.save(opinion);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody Opinion opinion, @PathVariable long id){
        service.update(opinion, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Opinion opinion){
        service.delete(opinion);
    }
}