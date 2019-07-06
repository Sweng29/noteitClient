package utils;

import java.util.List;

public interface GenericDAO<T> {

    T addOrUpdate(T entity);

    boolean deleteById(Integer id);

    T getById(Integer id);

    List<T> getAll();
}
