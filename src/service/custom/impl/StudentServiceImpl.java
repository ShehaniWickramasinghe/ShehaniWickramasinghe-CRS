package service.custom.impl;

import dao.DaoFactory;
import dao.custom.StudentDao;
import dto.Studentdto;
import entity.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import service.custom.StudentService;

public class StudentServiceImpl implements StudentService {
      private  StudentDao studentDao=(StudentDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);  
    @Override
    public String save(Studentdto studentdto) throws Exception {
      List<String> programList = new ArrayList<>(studentdto.getProgramOfStudy());
        StudentEntity studentEntity;
          studentEntity = new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
                  studentdto.getDOB(), studentdto.getPhoneNumber(), studentdto.getEmail(), programList);

         boolean isSaved =studentDao.save(studentEntity);
         return isSaved ? "success":"fail";
    }

    @Override
    public String update(Studentdto studentdto) throws Exception {
      List<String> programOfStudyString=new ArrayList<>(studentdto.getProgramOfStudy());
      StudentEntity studentEntity;
      studentEntity = new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
              studentdto.getDOB(),
              studentdto.getPhoneNumber(), studentdto.getEmail(), programOfStudyString);
       boolean isUpdate=studentDao.update(studentEntity);
       return isUpdate? "success":"fail";
    }

    @Override
    public String delete(String studentId) throws Exception {
       boolean isDelete=studentDao.delete(studentId);
       return isDelete ? "success":"fail";
    }

   @Override
   public Studentdto search(String studentId) throws Exception {
      StudentEntity studentEntity=studentDao.search(studentId);
      if (studentEntity!=null) {
         return new Studentdto(studentEntity.getStudentId(), studentEntity.getName(),
          studentEntity.getDOB(), studentEntity.getPhoneNumber(), studentEntity.getEmail(), studentEntity.getProgramOfStudy()); 
      }
      return null;
   }

}
