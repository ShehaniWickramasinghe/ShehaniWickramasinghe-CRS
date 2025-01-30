package service.custom.impl;

import dao.DaoFactory;
import dao.custom.StudentDao;
import dto.Studentdto;
import entity.StudentEntity;
import service.custom.StudentService;

public class StudentServiceImpl implements StudentService {
      private  StudentDao studentDao=(StudentDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);  
    @Override
    public String save(Studentdto studentdto) throws Exception {
        StudentEntity studentEntity=new StudentEntity(studentdto.getStudentId(), studentdto.getName(),
         studentdto.getDOB(), studentdto.getPhoneNumber(), studentdto.getEmail(), studentdto.getProgramOfStudy());

         boolean isSaved =studentDao.save(studentEntity);
         return isSaved ? "success":"fail";
    }

    @Override
    public String update(Studentdto studentdto) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public String delete(String studentId) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
