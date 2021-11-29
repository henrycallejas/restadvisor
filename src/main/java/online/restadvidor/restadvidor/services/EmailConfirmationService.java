package online.restadvidor.restadvidor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.EmailConfirmationRepository;
import online.restadvidor.restadvidor.model.EmailConfirm;

@Service
public class EmailConfirmationService implements CrudRestaurant<EmailConfirm, Long>{

	@Autowired
	EmailConfirmationRepository repository;

	@Override
	public List<EmailConfirm> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailConfirm save(EmailConfirm entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public void update(EmailConfirm entity, Long id) {
		if(id.intValue() > 0) {
			repository.save(entity);
		}
		
	}

	@Override
	public void delete(EmailConfirm entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmailConfirm get(long id) {
		return repository.findById(id).get();
	}
	
	public EmailConfirm findByConfirm(String confirm){
		return repository.findByConfirm(confirm);
	}

}
