package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseDao;
import entity.CourseEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public boolean save(CourseEntity t) throws Exception {
       String department=String.join(",", t.getDepartment());
       return CrudUtil.executeUpdate("INSERT INTO course VALUES(?,?,?,?,?,?)", t.getCourseId(),t.getName(),
       t.getCreditHour(),t.getPrerequisites(),t.getMaximumCapacity(),department);
    }

    @Override
    public boolean update(CourseEntity t) throws Exception {
        String department=String.join(",", t.getDepartment());
        return CrudUtil.executeUpdate("UPDATE course SET courseName=?,creditHours=?, prerequisites=?, MEC=?, department=? WHERE courseId=?", 
        t.getName(),t.getCreditHour(),t.getPrerequisites(),t.getMaximumCapacity(),department,t.getCourseId());
    }

    @Override
    public boolean delete(String id) throws Exception {
       return CrudUtil.executeUpdate("DELETE FROM course WHERE courseId=?", id);
    }

    @Override
    public CourseEntity search(String id) throws Exception {
       ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM course WHERE courseId=?", id);
       if (rst.next()) {
            return new CourseEntity(rst.getString("courseId"), rst.getString("courseName"), rst.getString("creditHours"),
            rst.getString("prerequisites"), rst.getInt("MEC"), Arrays.asList(rst.getString("department").split(",")));
       }
       return null;
    }

    @Override
    public ArrayList<CourseEntity> getAll() throws Exception {
       ArrayList<CourseEntity> courseEntities=new ArrayList<>();
       ResultSet rst=CrudUtil.extecuteQuery("SELECT * FROM course");
       while (rst.next()) {
        List<String> departments = Arrays.asList(rst.getString("department").split(","));
        
        courseEntities.add(new CourseEntity(rst.getString("courseId"),
        rst.getString("courseName"), rst.getString("creditHours"), rst.getString("prerequisites"),
        rst.getInt("MEC"), departments));
       }
       return courseEntities;
    }

}
