package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.StudentEntity;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO student VALUES(?,?,?,?,?,?)", t.getStudentId(),
        t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),t.getProgramOfStudy());
    }

    @Override
    public boolean update(StudentEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE student SET name=?, DOB=?, phoneNumber=?, email=?, programOfStudy=? WHERE studentId=?",
         t.getName(),t.getDOB(),t.getPhoneNumber(),t.getEmail(),t.getProgramOfStudy(),t.getStudentId());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM student WHERE studentId=?",id);
    }

    @Override
    public StudentEntity search(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public ArrayList<StudentEntity> getAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
