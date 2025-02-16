package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CheckDao;
import entity.CheckEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CheckDaoImpl implements CheckDao {

    @Override
    public boolean save(CheckEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(CheckEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CheckEntity search(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public List<CheckEntity> searchAll(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
    }

    @Override
    public ArrayList<CheckEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public CheckEntity check(String name) throws Exception {
        ResultSet rst=CrudUtil.extecuteQuery("SELECT courseName, prerequisites FROM course WHERE courseName = ?", name);
        if (rst.next()) {
            return new CheckEntity(rst.getString("courseName"),rst.getString("prerequisites"));
        }
        return null;
    }

}
