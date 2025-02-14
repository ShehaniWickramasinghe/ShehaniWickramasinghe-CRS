package service.custom.impl;

import dao.DaoFactory;
import dao.custom.ReportDao;
import dto.Reportdto;
import entity.ReportEntity;
import java.util.ArrayList;
import java.util.List;
import service.custom.ReportService;

public class ReportServiceImpl implements ReportService {
    private  ReportDao reportDao=(ReportDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.REPORT);
        
   @Override
public List<Reportdto> search(String studentId) throws Exception {
    List<ReportEntity> reportEntities = reportDao.searchAll(studentId);
    
    List<Reportdto> reportDtos = new ArrayList<>();
    
    for (ReportEntity entity : reportEntities) {
        reportDtos.add(new Reportdto(
            entity.getStudentId(),
            entity.getStudentName(),
            entity.getDepartment(),
            entity.getCourse(),
            entity.getSemester(),
            entity.getGrade()
        ));
    }
    return reportDtos;
}

@Override
public String update(Reportdto reportdto) throws Exception {
    List<Reportdto> reportdtos=new ArrayList<>();
    ReportEntity reportEntity=new ReportEntity(reportdto.getStudentId(), reportdto.getStudentName(), reportdto.getDepartment(),
    reportdto.getCourse(), reportdto.getSemester(), reportdto.getGrade());

    List<ReportEntity> existingReports = reportDao.searchAll(reportdto.getStudentId());
      
        
    boolean isUpdated=reportDao.update(reportEntity);
    return isUpdated?"success":"fail";
}


}
