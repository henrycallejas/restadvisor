package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.BranchOffice;
import online.restadvidor.restadvidor.services.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("branchs")
public class BranchOfficeController {

    @Autowired
    BranchOfficeService service;

    @GetMapping("/all")
    public List<BranchOffice> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public BranchOffice getById(@PathVariable("id") long id){
        return service.get(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody BranchOffice branch){
        service.save(branch);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody BranchOffice branch, @PathVariable long id){
        service.update(branch, id);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody BranchOffice branch){
        service.delete(branch);
    }
}