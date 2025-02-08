package dao;

import java.util.ArrayList;
import java.util.List;

public interface CrudDao<T, Id>extends SuperDao {
     boolean save(T t)throws Exception;
    boolean update(T t)throws Exception;
    boolean delete(String id)throws Exception;
    T search(Id id)throws Exception;
    List<T> searchAll(Id id) throws Exception;
    ArrayList<T> getAll()throws Exception;  
}
