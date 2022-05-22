package task2.database.repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository <T,I extends Serializable>{
    I save(T object);
    boolean delete(I id);
    List<T> findAll();
}
