package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.WorkDay;
import online.restadvidor.restadvidor.services.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("workdays")
public class WorkDayController {
    @Autowired
    WorkDayService service;

    @GetMapping("/all")
    public List<WorkDay> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WorkDay getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody WorkDay workDay){
        service.save(workDay);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody WorkDay workDay, @PathVariable long id){
        service.update(workDay, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody WorkDay workDay){
        service.delete(workDay);
    }
}