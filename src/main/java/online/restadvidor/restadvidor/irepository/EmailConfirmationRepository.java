package online.restadvidor.restadvidor.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import online.restadvidor.restadvidor.model.EmailConfirm;

@Repository
public interface EmailConfirmationRepository extends JpaRepository<EmailConfirm, Long>{
	public EmailConfirm findByConfirm(String confirm);
}
