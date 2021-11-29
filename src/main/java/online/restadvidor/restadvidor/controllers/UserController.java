package online.restadvidor.restadvidor.controllers;

import online.restadvidor.restadvidor.model.RestaurantUser;
import online.restadvidor.restadvidor.services.RestaurantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    
    @PostMapping("upload/{userId}")
    public ResponseEntity<String> uploadFiles(@RequestParam("files") List<MultipartFile> files, @PathVariable("userId") long userId){
    	try {
			service.uploadAll(files, userId);
			return ResponseEntity.status(HttpStatus.OK).body("Image uploaded");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to upload");
		}
    }

    @DeleteMapping("delete/{imageId}")
    public void deleteById(@PathVariable("imageId") long imageId) {
    	service.deleteById(imageId);
    }
}