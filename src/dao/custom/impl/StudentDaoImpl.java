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
        String sem1 = String.join(",", t.getSemester1());
        String sem2=String.join(",", t.getSemester2());
        return CrudUtil.executeUpdate("INSERT INTO student VALUES(?,?,?,?,?,?,?)", t.getStudentId(),
        t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),sem1,sem2);
    }

    @Override
    public boolean update(StudentEntity t) throws Exception {
        String sem1 = String.join(",", t.getSemester1());
        String sem2=String.join(",", t.getSemester2());
        return CrudUtil.executeUpdate("UPDATE student SET name=?, DOB=?, phoneNumber=?, email=?, Sem_1=?,Sem_2=? WHERE studentId=?",
         t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),sem1,sem2,t.getStudentId());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM student WHERE studentId=?",id);
    }

    @Override
    public StudentEntity search(String id) throws Exception {
       ResultSet rst = CrudUtil.extecuteQuery("SELECT * FROM student WHERE studentId=?", id);
       if (rst.next()) {
        String sem1=rst.getString("Semester 1");
        String sem2=rst.getString("Semester 2");
        List<String> semester1 = sem1 != null ? Arrays.asList(sem1.split(",")) : new ArrayList<>();
        List<String> semester2 = sem2 != null ? Arrays.asList( sem2.split(",")) : new ArrayList<>();
        return new StudentEntity(rst.getString("studentId"), rst.getString("name"), 
        rst.getDate("DOB").toLocalDate(),
         rst.getString("phoneNumber"), rst.getString("email"), semester1,semester2);
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
