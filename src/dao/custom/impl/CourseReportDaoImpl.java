package dao.custom.impl;

import java.util.ArrayList;
import java.util.List;

import dao.CrudUtil;
import dao.custom.CourseReportDao;
import entity.CourseReportEntity;
import java.sql.ResultSet;

public class CourseReportDaoImpl implements CourseReportDao{

    @Override
    public boolean save(CourseReportEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO course_report VALUES(?,?,?,?,?)",t.getName(),t.getEnrolledStudent(),
        t.getCompletedStudent(),t.getPerformance(),t.getRate());
    }

    @Override
    public boolean update(CourseReportEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE course_report SET enrolled_student=?,courseCompleted_students=?,student_performance=?, rate=? WHERE course_name=?",
        t.getEnrolledStudent(),
        t.getCompletedStudent(),t.getPerformance(),t.getRate(),t.getName());
    }

    @Override
    public boolean delete(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CourseReportEntity search(String id) throws Exception {
        ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM course_report WHERE course_name=?",id);

        if (rst.next()) {
            CourseReportEntity courseReportEntity=new CourseReportEntity(rst.getString("course_name"), 
            rst.getInt("enrolled_student"), rst.getInt("courseCompleted_students"),
             rst.getString("student_performance"), rst.getString("rate"));
        }
        return null;
    }

    @Override
    public List<CourseReportEntity> searchAll(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchAll'");
    }

    @Override
    public ArrayList<CourseReportEntity> getAll() throws Exception {
       ArrayList<CourseReportEntity> courseReportEntities=new ArrayList<>();
       ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM course_report");

       if (rst.next()) {
        courseReportEntities.add(new CourseReportEntity(rst.getString("course_name"), 
        rst.getInt("enrolled_student"), rst.getInt("courseCompleted_students"),
         rst.getString("student_performance"), rst.getString("rate")));
       }
       return courseReportEntities;
    }

   

}
