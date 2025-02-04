package dao.custom.impl;

import dao.custom.ReportDao;
import db.DBConnection;
import entity.ReportEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReportDaoImpl implements ReportDao {

    @Override
    public boolean save(ReportEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(ReportEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ReportEntity search(String id) throws Exception {
        String query = "SELECT * FROM report WHERE studentId = ?";
       try(Connection connection=DBConnection.getInstance().getConnection();
       PreparedStatement statement=connection.prepareStatement(query)){
        statement.setString(1, id);
        ResultSet rst=statement.executeQuery();
        if (rst.next()) {
         return new ReportEntity(rst.getString("studentId"), rst.getString("studentName"),
         rst.getString("department"), rst.getString("course"),rst.getString("grade"));
        }
       }
           
       return null;
       
    }

    @Override
    public ArrayList<ReportEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
