package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.LoginDao;
import entity.LoginEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean save(LoginEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO login VALUES(?,?)",t.getName(),t.getPassword());
    }

    @Override
    public boolean update(LoginEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM login WHERE user_name=? ", id);
    }

    @Override
    public LoginEntity search(String id) throws Exception {
       ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM login WHERE user_name=?",id);
       if (rst.next()) {
        return new LoginEntity(rst.getString("user_name"), rst.getString("password"));
       }
       return null;
    }

    @Override
    public List<LoginEntity> searchAll(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
    }

    @Override
    public ArrayList<LoginEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
