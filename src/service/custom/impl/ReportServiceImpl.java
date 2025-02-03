package service.custom.impl;

import dao.DaoFactory;
import dao.custom.ReportDao;
import dto.Reportdto;
import entity.ReportEntity;
import service.custom.ReportService;

public class ReportServiceImpl implements ReportService {
    private  ReportDao reportDao=(ReportDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.REPORT);

    @Override
    public Reportdto search(String StudentId) throws Exception {
        ReportEntity reportEntity=reportDao.search(StudentId);
        if (reportEntity!=null) {
           return new Reportdto(reportEntity.getStudentId(),reportEntity.getStudentName(),
            reportEntity.getDepartment(), reportEntity.getCourseName(),reportEntity.getGrade()); 
        }
        return null;
    }

}
