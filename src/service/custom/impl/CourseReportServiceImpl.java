package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CourseReportDao;
import dto.CourseReportdto;
import entity.CourseReportEntity;
import java.util.ArrayList;
import service.custom.CourseReportService;

public class CourseReportServiceImpl implements CourseReportService{
                CourseReportDao courseReportDao=(CourseReportDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.COURSE_REPORT);
    @Override
    public String save(CourseReportdto courseReportdto) throws Exception {
        CourseReportEntity courseReportEntity=new CourseReportEntity(courseReportdto.getName(),
        courseReportdto.getEnrolledStudent(), courseReportdto.getCompletedStudent(), courseReportdto.getPerformance(),
        courseReportdto.getRate());

        boolean isSaved=courseReportDao.save(courseReportEntity);
        return isSaved? "success":"fail";
    }

    @Override
    public String update(CourseReportdto courseReportdto) throws Exception {
        CourseReportEntity courseReportEntity=new CourseReportEntity(courseReportdto.getName(),
        courseReportdto.getEnrolledStudent(), courseReportdto.getCompletedStudent(), courseReportdto.getPerformance(),
        courseReportdto.getRate());

        boolean isUpdated=courseReportDao.update(courseReportEntity);
        return isUpdated? "success":"fail";
    }

    @Override
    public CourseReportdto search(String name) throws Exception {
        CourseReportEntity courseReportEntity=courseReportDao.search(name);

        if (courseReportEntity!=null) {
            return new CourseReportdto(courseReportEntity.getName(), courseReportEntity.getEnrolledStudent(),
            courseReportEntity.getCompletedStudent(), courseReportEntity.getPerformance(), courseReportEntity.getRate());
        }
        return null;
    }

    @Override
    public ArrayList<CourseReportdto> getAll() throws Exception {
        ArrayList<CourseReportdto> courseReportdtos=new ArrayList<>();
        ArrayList<CourseReportEntity> courseReportEntities=courseReportDao.getAll();
        
        for (CourseReportEntity courseReportEntity : courseReportEntities) {
            CourseReportdto dto=new CourseReportdto(courseReportEntity.getName(), courseReportEntity.getEnrolledStudent(), 
            courseReportEntity.getCompletedStudent(), courseReportEntity.getPerformance(), courseReportEntity.getRate());
            courseReportdtos.add(dto);
        }
        return courseReportdtos;
    }

}
