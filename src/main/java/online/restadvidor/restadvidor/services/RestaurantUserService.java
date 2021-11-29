package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RestaurantUserRepository;
import online.restadvidor.restadvidor.model.Image;
import online.restadvidor.restadvidor.model.RestaurantUser;
import online.restadvidor.restadvidor.utils.ImagesPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantUserService implements CrudRestaurant<RestaurantUser, Long> {

    @Autowired
    RestaurantUserRepository restaurantUserRepository;

    @Override
    public List<RestaurantUser> getAll() {
        return restaurantUserRepository.findAll();
    }

    @Override
    public RestaurantUser save(RestaurantUser entity) {
        return restaurantUserRepository.save(entity);
    }

    @Override
    public void update(RestaurantUser entity, Long id) {
        if(id.intValue() >0 ){
            restaurantUserRepository.save(entity);
        }
    }

    @Override
    public void delete(RestaurantUser entity) {
        restaurantUserRepository.delete(entity);
    }

    @Override
    public RestaurantUser get(long id) {
        return restaurantUserRepository.findById(id).get();
    }
    
    public Optional<RestaurantUser> findByUsername(String username){
    	return restaurantUserRepository.findByUsername(username);
    }
    
    public Optional<RestaurantUser> findByEmail(String email){
    	return restaurantUserRepository.findByEmail(email);
    }

	public Boolean existsByUsername(String username) {
		return restaurantUserRepository.existsByUsername(username);
	}

	public Boolean existsByEmail(String email) {
		return restaurantUserRepository.existsByEmail(email);
	}
	
	private Path rootFolder = Paths.get("");
	public void uploadFile(MultipartFile file) {
		StringBuilder builder = ImagesPath.getPath();
		builder.append(file.getOriginalFilename());
		System.out.println(builder.toString());
		try {
			Files.copy(file.getInputStream(), rootFolder.resolve(builder.toString()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void uploadAll(List<MultipartFile> files, long userId) {
		
		for(MultipartFile f : files) {
			this.uploadFile(f);
			RestaurantUser user = new RestaurantUser();
			user.setUserId(userId);
			user.setProfilePic(f.getOriginalFilename());
			restaurantUserRepository.save(user);
		}
	}
	
	public void deleteById(long imageId) {
		StringBuilder builder = ImagesPath.getPath();
		RestaurantUser user = restaurantUserRepository.findById(imageId).get();
		builder.append(user.getProfilePic());
		user.setProfilePic("");
		try {
			Files.delete(rootFolder.resolve(builder.toString()));;
			restaurantUserRepository.save(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RestaurantUser findByConfirm(String confirm) {
		return restaurantUserRepository.findByConfirm(confirm);
	}
}