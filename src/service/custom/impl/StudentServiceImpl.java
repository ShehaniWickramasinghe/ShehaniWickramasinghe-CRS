package service.custom.impl;

import dao.DaoFactory;
import dao.custom.LoginDao;
import dao.custom.StudentDao;
import db.DBConnection;
import dto.Logindto;
import dto.Studentdto;
import entity.LoginEntity;
import entity.StudentEntity;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import service.custom.StudentService;

public class StudentServiceImpl implements StudentService {
      private  StudentDao studentDao=(StudentDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);  
      private LoginDao loginDao=(LoginDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.LOGIN);
      @Override
    public String save(Studentdto studentdto, List<Logindto>loginList) throws Exception {
      if (loginList == null) {
         return "Error: Login list cannot be null.";
     }
      Connection connection=DBConnection.getInstance().getConnection();
      try {
          connection.setAutoCommit(false);
          List<String> sem1 = new ArrayList<>(studentdto.getSemester1());
          List<String> sem2 = new ArrayList<>(studentdto.getSemester2());
            StudentEntity studentEntity;
              studentEntity = new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
                      studentdto.getDOB(), studentdto.getPhoneNumber(), 
                      studentdto.getEmail(), sem1,sem2);
    
             boolean isSaved =studentDao.save(studentEntity);
             if (!isSaved) {
                        connection.rollback();
                        alert(Alert.AlertType.ERROR, "Fail", "Failed to save course. Please try again.");
                        return "Failed to save course";
                    }
             boolean isAllSaved=true;

             for (Logindto logindto : loginList) {
                LoginEntity loginEntity=new LoginEntity(logindto.getName(), logindto.getPassword());
                boolean loginSaved=loginDao.save(loginEntity);

                String newStuent=studentdto.getStudentId();
                String newUser=logindto.getName();
                String newPassword=logindto.getPassword();
                if(isSaved){
                 newUser=newStuent;
                 newPassword=newStuent;
                }

                 if (!loginSaved) {
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
    public String delete(String studentId) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
    
            boolean isStudentDeleted = studentDao.delete(studentId);
            boolean isLoginDeleted = loginDao.delete(studentId);
    
            if (!isStudentDeleted || !isLoginDeleted) {
                connection.rollback();
                System.out.println("Failed to delete student and login details. Transaction rolled back.");
                return "Failed to delete student";
            }
    
            connection.commit();
            System.out.println("Student and login details deleted successfully.");
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
    public String update(Studentdto studentdto) throws Exception {
      List<String> sem1 = new ArrayList<>(studentdto.getSemester1());
      List<String> sem2 = new ArrayList<>(studentdto.getSemester2());
      StudentEntity studentEntity;
      studentEntity = new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
              studentdto.getDOB(),
              studentdto.getPhoneNumber(), studentdto.getEmail(), sem1,sem2);
       boolean isUpdate=studentDao.update(studentEntity);
       return isUpdate? "success":"fail";
    }


   @Override
   public Studentdto search(String studentId) throws Exception {
      StudentEntity studentEntity=studentDao.search(studentId);
      if (studentEntity!=null) {
         return new Studentdto(studentEntity.getStudentId(), studentEntity.getName(),
          studentEntity.getDOB(), studentEntity.getPhoneNumber(), studentEntity.getEmail(), studentEntity.getSemester1(),
          studentEntity.getSemester2()); 
      }
      return null;
   }

   @Override
   public ArrayList<Studentdto> getAll() throws Exception {
       ArrayList<Studentdto> studentdtos=new ArrayList<>();
       ArrayList<StudentEntity> studentEntities=studentDao.getAll();
       for (StudentEntity studentEntity : studentEntities) {
          Studentdto dto=new Studentdto(studentEntity.getStudentId(), studentEntity.getName(),
          studentEntity.getDOB(),studentEntity.getPhoneNumber(), studentEntity.getEmail(), studentEntity.getSemester1(), 
          studentEntity.getSemester2()) ;
          studentdtos.add(dto);
       }
       return studentdtos;
   }
   @SuppressWarnings("unused")
   private void alert(Alert.AlertType alertType,String header,String context){
       Alert alert=new Alert(alertType);
       alert.setHeaderText(header);
       alert.setContentText(context);
       alert.showAndWait();
   }

}
