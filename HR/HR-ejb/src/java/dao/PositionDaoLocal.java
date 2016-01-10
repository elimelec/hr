package dao;

import Entity.Position;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PositionDaoLocal {
    void add(Position position);

    void delete(Integer id);

    void update(Position position);

    Position getItemById(Integer id);

    List<Position> getAll();
}
