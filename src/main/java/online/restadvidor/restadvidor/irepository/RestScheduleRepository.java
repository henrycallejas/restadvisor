package online.restadvidor.restadvidor.irepository;

import online.restadvidor.restadvidor.model.RestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestScheduleRepository extends JpaRepository<RestSchedule, Integer> {
}
