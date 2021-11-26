package online.restadvidor.restadvidor.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.restadvidor.restadvidor.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	public List<Image> findByBranchId(long id);
}
