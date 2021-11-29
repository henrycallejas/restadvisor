package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RolRepository;
import online.restadvidor.restadvidor.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements CrudRestaurant<Role, Long> {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Role> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Role save(Role entity) {
        return rolRepository.save(entity);
    }

    @Override
    public void update(Role entity, Long id) {
        if (id.intValue() >0){
            rolRepository.save(entity);
        }
    }

    @Override
    public void delete(Role entity) {
        rolRepository.delete(entity);
    }

    @Override
    public Role get(long id) {
        return rolRepository.findById(id).get();
    }
}