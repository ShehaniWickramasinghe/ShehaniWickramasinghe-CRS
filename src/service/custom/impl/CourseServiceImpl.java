package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CourseDao;
import dto.Coursedto;
import entity.CourseEntity;
import java.util.ArrayList;
import java.util.List;
import service.custom.CourseService;

public class CourseServiceImpl implements CourseService {
            private CourseDao courseDao=(CourseDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE);
    @Override
    public String save(Coursedto coursedto) throws Exception {
        List<String> CourseList=new ArrayList<>(coursedto.getDepartment());
        CourseEntity courseEntity=new CourseEntity(coursedto.getCourseId(), coursedto.getName(), coursedto.getCreditHour(), coursedto.getPrerequisites(), coursedto.getMaximumCapacity(), CourseList);

        boolean isSaved=courseDao.save(courseEntity);
        return isSaved ? "Success":"fail";
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
        }
        return coursedto;
    }

}
