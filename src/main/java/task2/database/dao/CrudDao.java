package task2.database.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudDao<T,I extends Serializable>{
    I save(T object);
    boolean delete(I id);
    List<T> findAll();
}
