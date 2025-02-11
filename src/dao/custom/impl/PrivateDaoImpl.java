package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PrivateDao;
import entity.PrivateEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PrivateDaoImpl implements PrivateDao {

    @Override
    public boolean save(PrivateEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO private VALUES(?,?,?,?,?,?)", t.getId(),
        t.getName(),t.getDepartment(),t.getAttendance(),
        t.getSem1Grade(),t.getSem2Grade());
    }

    @Override
    public boolean update(PrivateEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE private SET name=?,department=?,attendance=?,sem1_grade=?,sem2_grade=? WHERE Id=?",
        t.getName(),t.getDepartment(),t.getAttendance(),t.getSem1Grade(),t.getSem2Grade(),t.getId());
    }

    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PrivateEntity search(String id) throws Exception {
        ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM private WHERE id=?", id);
        if (rst.next()) {
            return new PrivateEntity(rst.getString("Id"), rst.getString("name"), 
            rst.getString("department"), rst.getString("attendance"), rst.getString("sem1_grade"), 
            rst.getString("sem2_grade"));
        }
        return null;
    }

    @Override
    public List<PrivateEntity> searchAll(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
    }

    @Override
    public ArrayList<PrivateEntity> getAll() throws Exception {
        ArrayList<PrivateEntity> privateEntities=new ArrayList<>();
        ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM private");
        while (rst.next()) {
            privateEntities.add(new PrivateEntity(rst.getString("Id"), rst.getString("name"), rst.getString("department"),
             rst.getString("attendance"), rst.getString("sem1_grade"), rst.getString("sem2_grade")));
        }
        return privateEntities;
    }

}
