package online.restadvidor.restadvidor.irepository;

import java.io.Serializable;
import java.util.List;

public interface CrudRestaurant<T>  {
    public List<T> getAll();
    public T save(T entity);
    public void delete(T entity);
    public T get(T entity);
}
