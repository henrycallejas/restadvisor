package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
}
