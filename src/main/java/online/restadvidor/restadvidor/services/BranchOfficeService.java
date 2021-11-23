package online.restadvidor.restadvidor.services;

import online.restadvidor.restadvidor.irepository.BranchOfficeRepository;
import online.restadvidor.restadvidor.irepository.CrudRestaurant;
import online.restadvidor.restadvidor.model.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchOfficeService implements CrudRestaurant<BranchOffice, Long> {

    @Autowired
    BranchOfficeRepository branchRepository;

    @Override
    public List<BranchOffice> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public BranchOffice save(BranchOffice entity) {
        return branchRepository.save(entity);
    }

    @Override
    public void update(BranchOffice entity, Long id) {
        if(id.intValue() >0){
            branchRepository.save(entity);
        }
    }

    @Override
    public void delete(BranchOffice entity) {
        branchRepository.delete(entity);
    }

    @Override
    public BranchOffice get(long id) {
        return branchRepository.findById(id).get();
    }

}