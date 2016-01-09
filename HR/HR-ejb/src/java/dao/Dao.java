package dao;

import java.util.List;
import javax.ejb.Local;

@Local
public abstract class Dao<T> {

    abstract void add(T position);

    abstract void delete(Integer id);

    abstract void update(T position);

    abstract T getItemById(Integer id);

    abstract List<T> getAll();
}
