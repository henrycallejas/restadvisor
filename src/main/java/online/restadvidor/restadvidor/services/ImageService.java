package online.restadvidor.restadvidor.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.ImageRepository;
import online.restadvidor.restadvidor.model.Image;
import online.restadvidor.restadvidor.utils.ImagesPath;

@Service
public class ImageService implements CrudRestaurant<Image, Long>{

	@Autowired
	ImageRepository imageRepository;
	
	@Override
	public List<Image> getAll() {
		return imageRepository.findAll();
	}

	@Override
	public Image save(Image entity) {
		return imageRepository.save(entity);
	}
	

	@Override
	public void update(Image entity, Long id) {
		if(id.intValue() >0) {
			imageRepository.save(entity);
		}
		
	}

	@Override
	public void delete(Image entity) {
		imageRepository.delete(entity);
		
	}

	@Override
	public Image get(long id) {
		return imageRepository.findById(id).get();
	}
	
	
	public List<Image> getByBranchId(long branchId){
		return imageRepository.findByBranchId(branchId);
	}
	
	
	private Path rootFolder = Paths.get("");
	
	public void upload(MultipartFile file) {
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
	
	public void uploadAll(List<MultipartFile> files, long branchId) {
		
		for(MultipartFile f : files) {
			this.upload(f);
			Image imagen = new Image();
			imagen.setBranchId(branchId);
			imagen.setPath(f.getOriginalFilename());
			imageRepository.save(imagen);
		}
	}
	
	public void deleteById(long imageId) {
		StringBuilder builder = ImagesPath.getPath();
		builder.append(imageRepository.findById(imageId).get().getPath());
		imageRepository.deleteById(imageId);
		try {
			Files.delete(rootFolder.resolve(builder.toString()));;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
