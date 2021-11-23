package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.irepository.WorkDayRepository;
import online.restadvidor.restadvidor.model.WorkDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkDayService implements CrudRestaurant<WorkDay, Long> {
    @Autowired
    WorkDayRepository workDayRepository;

    @Override
    public List<WorkDay> getAll() {
        return workDayRepository.findAll();
    }

    @Override
    public WorkDay save(WorkDay entity) {
        return workDayRepository.save(entity);
    }

    @Override
    public void update(WorkDay entity, Long id) {
        if(id.intValue() >0){
            workDayRepository.save(entity);
        }
    }

    @Override
    public void delete(WorkDay entity) {
        workDayRepository.delete(entity);
    }

    @Override
    public WorkDay get(long id) {
        return workDayRepository.findById(id).get();
    }
}