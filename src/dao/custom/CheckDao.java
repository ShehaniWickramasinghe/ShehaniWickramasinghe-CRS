package dao.custom;

import dao.CrudDao;
import entity.CheckEntity;

public interface CheckDao extends CrudDao<CheckEntity,String> {
    public CheckEntity check(String name) throws Exception;
}
