package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer> {
}
