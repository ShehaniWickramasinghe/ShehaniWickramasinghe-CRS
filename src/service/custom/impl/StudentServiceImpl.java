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
      List<String> sem1 = new ArrayList<>(studentdto.getSemester1());
      List<String> sem2 = new ArrayList<>(studentdto.getSemester2());
        StudentEntity studentEntity;
          studentEntity = new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
                  studentdto.getDOB(), studentdto.getPhoneNumber(), studentdto.getEmail(), sem1,sem2);

         boolean isSaved =studentDao.save(studentEntity);
         return isSaved ? "success":"fail";
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
    public String delete(String studentId) throws Exception {
       boolean isDelete=studentDao.delete(studentId);
       return isDelete ? "success":"fail";
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

}
