package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.StudentEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(StudentEntity t) throws Exception {
        String programOfStudyString = String.join(",", t.getProgramOfStudy());
        return CrudUtil.executeUpdate("INSERT INTO student VALUES(?,?,?,?,?,?)", t.getStudentId(),
        t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),programOfStudyString);
    }

    @Override
    public boolean update(StudentEntity t) throws Exception {
        String programOfStudyString = String.join("", t.getProgramOfStudy());
        return CrudUtil.executeUpdate("UPDATE student SET name=?, DOB=?, phoneNumber=?, email=?, programOfStudy=? WHERE studentId=?",
         t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),programOfStudyString,t.getStudentId());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM student WHERE studentId=?",id);
    }

    @Override
    public StudentEntity search(String id) throws Exception {
       ResultSet rst = CrudUtil.extecuteQuery("SELECT * FROM student WHERE studentId=?", id);
       if (rst.next()) {
        String programString=rst.getString("programOfStudy");
        List<String> programOfStudy = programString != null ? Arrays.asList(programString.split(",")) : new ArrayList<>();
        return new StudentEntity(rst.getString("studentId"), rst.getString("name"), 
        rst.getDate("DOB").toLocalDate(),
         rst.getString("phoneNumber"), rst.getString("email"), programOfStudy);
       }
       return null;
    }

    @Override
    public ArrayList<StudentEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public List<StudentEntity> searchAll(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
    }

}
