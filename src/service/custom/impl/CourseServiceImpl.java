package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dao.custom.StudentDao;
import db.DBConnection;
import dto.Coursedto;
import dto.Studentdto;
import entity.CourseEntity;
import entity.StudentEntity;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import service.custom.CourseService;

public class CourseServiceImpl implements CourseService {
            private CourseDao courseDao=(CourseDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE);
            private StudentDao studentDao=(StudentDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

            @Override
            public String save(Coursedto coursedto, List<Studentdto> studentList) throws Exception {
                Connection connection = DBConnection.getInstance().getConnection();
                
                try {
                    connection.setAutoCommit(false); // Start transaction
            
                    // Creating CourseEntity
                    List<String> courseList = new ArrayList<>(coursedto.getDepartment());
                    CourseEntity courseEntity = new CourseEntity(
                        coursedto.getCourseId(),
                        coursedto.getName(),
                        coursedto.getCreditHour(),
                        coursedto.getPrerequisites(),
                        coursedto.getMaximumCapacity(),
                        courseList
                    );
            
                    boolean isSaved = courseDao.save(courseEntity);
                    if (!isSaved) {
                        connection.rollback();
                        alert(Alert.AlertType.ERROR, "Fail", "Failed to save course. Please try again.");
                        return "Failed to save course";
                    }
            
                    boolean isAllSaved = true;
            
                    
                    for (Studentdto studentdto : studentList) {
                        List<String> sem1 = new ArrayList<>(studentdto.getSemester1());
                        List<String> sem2 = new ArrayList<>(studentdto.getSemester2());
            
                        String newCourse = coursedto.getName(); 

                        if (!sem1.contains(newCourse) && !sem2.contains(newCourse)) {
                            if (sem1.size() <= sem2.size()) {
                                sem1.add(newCourse); 
                            } else {
                                sem2.add(newCourse); 
                            }
                        }
            
                        StudentEntity studentEntity = new StudentEntity(
                            studentdto.getStudentId(),
                            studentdto.getName(),
                            studentdto.getDOB(),
                            studentdto.getPhoneNumber(),
                            studentdto.getEmail(),
                            sem1,
                            sem2
                        );
            
                        boolean studentSaved = studentDao.save(studentEntity);
                        if (!studentSaved) {
                            isAllSaved = false;
                            break;
                        }
                    }
            
                    if (!isAllSaved) {
                        connection.rollback();
                        alert(Alert.AlertType.ERROR, "Fail", "Failed to save students. Transaction rolled back.");
                        return "Failed to save students";
                    }
            
                    connection.commit(); 
                    alert(Alert.AlertType.CONFIRMATION, "Success", "Course and students saved successfully!");
                    return "Success";
            
                } catch (Exception e) {
                    connection.rollback(); 
                    e.printStackTrace(); 
                    return "Error occurred: " + e.getMessage();
                } finally {
                    connection.setAutoCommit(true); 
                }
            }
            

    @Override
    public String update(Coursedto coursedto) throws Exception {
        List<String> CourseList=new ArrayList<>(coursedto.getDepartment());
        CourseEntity courseEntity=new CourseEntity(coursedto.getCourseId(), coursedto.getName(), coursedto.getCreditHour(),
         coursedto.getPrerequisites(), coursedto.getMaximumCapacity(), CourseList);

         boolean isUpdate=courseDao.update(courseEntity);
         return isUpdate ? "Success":"fail";
    }

    @Override
    public Coursedto search(String courseId) throws Exception {
       CourseEntity courseEntity=courseDao.search(courseId);
       if (courseEntity!=null) {
        return new Coursedto(courseEntity.getCourseId(), courseEntity.getName(), courseEntity.getCreditHour(), 
        courseEntity.getPrerequisites(), courseEntity.getMaximumCapacity(), courseEntity.getDepartment());
       }
       return null;
    }

    @Override
    public String delete(String courseId) throws Exception {
        boolean isDelete=courseDao.delete(courseId);
        return  isDelete ? "Success":"fail";
    }

    @Override
    public ArrayList<Coursedto> getAll() throws Exception {
        ArrayList<Coursedto> coursedto=new ArrayList<>();
        ArrayList<CourseEntity> courseEntities=courseDao.getAll();
        for (CourseEntity courseEntity : courseEntities) {
            Coursedto dto=new Coursedto(courseEntity.getCourseId(), courseEntity.getName(), courseEntity.getCreditHour(), courseEntity.getPrerequisites(), courseEntity.getMaximumCapacity(), courseEntity.getDepartment());
            coursedto.add(dto);
        }
        return coursedto;
    }

     @SuppressWarnings("unused")
    private void alert(Alert.AlertType alertType,String header,String context){
        Alert alert=new Alert(alertType);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }

}
