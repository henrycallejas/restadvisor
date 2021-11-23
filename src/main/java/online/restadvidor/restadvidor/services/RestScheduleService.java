package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.RestScheduleRepository;
import online.restadvidor.restadvidor.model.RestSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestScheduleService implements CrudRestaurant<RestSchedule, Long> {

    @Autowired
    RestScheduleRepository restScheduleRepository;

    @Override
    public List<RestSchedule> getAll() {
        return restScheduleRepository.findAll();
    }

    @Override
    public RestSchedule save(RestSchedule entity) {
        return restScheduleRepository.save(entity);
    }

    @Override
    public void update(RestSchedule entity, Long id) {
        if(id.intValue() >0){
            restScheduleRepository.save(entity);
        }
    }

    @Override
    public void delete(RestSchedule entity) {
        restScheduleRepository.delete(entity);
    }

    @Override
    public RestSchedule get(long id) {
        return restScheduleRepository.findById(id).get();
    }
}