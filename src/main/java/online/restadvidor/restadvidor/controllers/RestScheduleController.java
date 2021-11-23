package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.RestSchedule;
import online.restadvidor.restadvidor.model.Restaurant;
import online.restadvidor.restadvidor.services.RestScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedules")
public class RestScheduleController {

    @Autowired
    RestScheduleService service;

    @GetMapping("/all")
    public List<RestSchedule> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RestSchedule getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody RestSchedule schedule){
        service.save(schedule);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody RestSchedule schedule, @PathVariable long id){
        service.update(schedule, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody RestSchedule schedule){
        service.delete(schedule);
    }

}