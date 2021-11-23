package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.OpinionRepository;
import online.restadvidor.restadvidor.model.Opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService implements CrudRestaurant<Opinion, Long> {

    @Autowired
    OpinionRepository opinionRepository;

    @Override
    public List<Opinion> getAll() {
        return opinionRepository.findAll();
    }

    @Override
    public Opinion save(Opinion entity) {
        return opinionRepository.save(entity);
    }

    @Override
    public void update(Opinion entity, Long id) {
        if(id.intValue() >0){
            opinionRepository.save(entity);
        }
    }

    @Override
    public void delete(Opinion entity) {
        opinionRepository.delete(entity);
    }

    @Override
    public Opinion get(long id) {
        return opinionRepository.findById(id).get();
    }
}