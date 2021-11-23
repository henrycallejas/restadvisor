package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RolRepository;
import online.restadvidor.restadvidor.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements CrudRestaurant<Rol, Long> {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol save(Rol entity) {
        return rolRepository.save(entity);
    }

    @Override
    public void update(Rol entity, Long id) {
        if (id.intValue() >0){
            rolRepository.save(entity);
        }
    }

    @Override
    public void delete(Rol entity) {
        rolRepository.delete(entity);
    }

    @Override
    public Rol get(long id) {
        return rolRepository.findById(id).get();
    }
}