package dao.custom.impl;

import dao.custom.ReportDao;
import db.DBConnection;
import entity.ReportEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {
        private Connection connection;

        public ReportDaoImpl(){
            try {
                this.connection=DBConnection.getInstance().getConnection();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public ReportDaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean save(ReportEntity t) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public boolean update(ReportEntity t) throws Exception {
        String sql = "UPDATE report SET studentName=?,department=?,grade=? WHERE studentId=? AND semester=? AND course=?";

        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, t.getStudentName());
            ps.setString(2, t.getDepartment());
            ps.setString(3, t.getGrade());
            ps.setString(4, t.getStudentId());
            ps.setString(5, t.getSemester().trim());
            ps.setString(6, t.getCourse());
            
            int rowsAffected = ps.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected + " for " + t);
            return rowsAffected > 0; 
        }
    }

    @Override
    public List<ReportEntity> searchAll(String id) throws Exception {
          String query = "SELECT * FROM report WHERE studentId = ?";
        List<ReportEntity> reportList =new ArrayList<>();

       try(Connection connection=DBConnection.getInstance().getConnection();
       PreparedStatement statement=connection.prepareStatement(query)){
        statement.setString(1, id);
        ResultSet rst=statement.executeQuery();
        while (rst.next()) {
            ReportEntity report = new ReportEntity(
                rst.getString("studentId"),
                rst.getString("studentName"),
                rst.getString("department"),
                rst.getString("course"),
                rst.getString("semester"),
                rst.getString("grade")
            );
            reportList.add(report);
           
        }
    }
           
       return reportList;
    }
    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stu
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ReportEntity search(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }


    @Override
    public ArrayList<ReportEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public ReportEntity findById(String studentId, String semester, String course) throws Exception {
        String sql = "SELECT * FROM report WHERE studentId=? AND semester=? AND course=?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, studentId);
            ps.setString(2, semester.trim());
            ps.setString(3, course);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ReportEntity(
                        rs.getString("studentId"),
                        rs.getString("studentName"),
                        rs.getString("department"),
                        rs.getString("course"),
                        rs.getString("semester"),
                        rs.getString("grade")
                    );
                }
            }
        }
        return null;
    }

 

   
    
            

}
