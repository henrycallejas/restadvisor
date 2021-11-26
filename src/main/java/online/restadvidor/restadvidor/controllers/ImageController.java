package online.restadvidor.restadvidor.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import online.restadvidor.restadvidor.model.Image;
import online.restadvidor.restadvidor.services.ImageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("images")
public class ImageController {
	
	@Autowired
    ImageService service;

    @GetMapping("/all")
    public List<Image> getAll(){
        return service.getAll();
    }
    
    
    @GetMapping("/{id}")
    public Image getById(@PathVariable("id") long id){
        return service.get(id);
    }
    
    @GetMapping("all/{branchId}")
    public List<Image> getAllByBranchId(@PathVariable("branchId") long branchId){
    	return service.getByBranchId(branchId);
    }
    
    @PostMapping("uploadfile/{branchId}")
    public ResponseEntity<String> uploadFiles(@RequestParam("files") List<MultipartFile> files, @PathVariable("branchId") long branchId){
    	try {
			service.uploadAll(files, branchId);
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
