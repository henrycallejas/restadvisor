package online.restadvidor.restadvidor.irepository;

import java.io.Serializable;
import java.util.List;

public interface CrudRestaurant<T, Long>  {
    public List<T> getAll();
    public T save(T entity);
    public void update(T entity, Long id);
    public void delete(T entity);
    public T get(long id);
}
