package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.ERole;
import online.restadvidor.restadvidor.model.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}