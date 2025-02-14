package service.custom.impl;

import dao.DaoFactory;
import dao.custom.PrivateDao;
import dao.custom.ReportDao;
import dao.custom.impl.ReportDaoImpl;
import db.DBConnection;
import dto.Privatedto;
import dto.Reportdto;
import entity.PrivateEntity;
import entity.ReportEntity;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import service.custom.PrivateService;

public class PrivateServiceImpl implements PrivateService{
            private PrivateDao privateDao=(PrivateDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.PRIVATE);
            private ReportDao reportDao=(ReportDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.REPORT);
    @Override
    public String save(Privatedto privatedto) throws Exception {
        PrivateEntity privateEntity=new PrivateEntity(privatedto.getId(), privatedto.getName(),
        privatedto.getDepartment(),privatedto.getAttendance(), privatedto.getSem1Grade(), privatedto.getSem2Grade());

        boolean isSaved=privateDao.save(privateEntity);
        return isSaved ? "Success":"fail";
    }

    @Override
    public String update(Privatedto privatedto, List<Reportdto> reportList) throws Exception {
        
        Connection connection=DBConnection.getInstance().getConnection();
        ReportDao reportDao=new ReportDaoImpl(connection);

        try {
            connection.setAutoCommit(false);
            PrivateEntity privateEntity=new PrivateEntity(privatedto.getId(), privatedto.getName(),
            privatedto.getDepartment(), privatedto.getAttendance(), privatedto.getSem1Grade(), privatedto.getSem2Grade());
            System.out.println("Updating private entity: " + privateEntity);

            boolean isPrivateUpdate = privateDao.update(privateEntity);

            boolean allReportsUpdated = true;
            for (Reportdto reportdto : reportList) {
                ReportEntity reportEntity=new ReportEntity(reportdto.getStudentId(), reportdto.getStudentName(), reportdto.getDepartment(), 
                reportdto.getCourse(), reportdto.getSemester(), reportdto.getGrade());
                
               if (reportdto.getStudentId().equals(privatedto.getId())) {
                if (reportdto.getSemester().equals("Semester 1")) {
                    reportEntity.setGrade(privatedto.getSem1Grade());
                }else if (reportdto.getSemester().equals("semester 2")) {
                    reportEntity.setGrade(privatedto.getSem2Grade());
                }
               }
                boolean isReportUpdate = reportDao.update(reportEntity);
                
                
                if (!isReportUpdate) {
                    allReportsUpdated=false;
                    break;
                }
            }

            
            if (isPrivateUpdate && allReportsUpdated) {
                connection.commit();
                return "Update successful";
            } else {
                connection.rollback();
                return "Update failed";
            }


        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            return "Transaction failed: " + e.getMessage();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); 
                    connection.close(); 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public Privatedto search(String id) throws Exception {
        PrivateEntity privateEntity=privateDao.search(id);
        if (privateEntity!=null) {
            return new Privatedto(privateEntity.getId(), privateEntity.getName(), privateEntity.getDepartment(), privateEntity.getAttendance(),
            privateEntity.getSem1Grade(),privateEntity.getSem2Grade());

        }
        return null;
    }

    @Override
    public ArrayList<Privatedto> getAll() throws Exception {
       ArrayList<Privatedto> privatedtos=new ArrayList<>();
       ArrayList<PrivateEntity> privateEntities=privateDao.getAll();
       for (PrivateEntity privateEntity : privateEntities) {
           Privatedto dto=new Privatedto(
        privateEntity.getId(),privateEntity.getName(),privateEntity.getDepartment(),
           privateEntity.getAttendance(),
           privateEntity.getSem1Grade(),privateEntity.getSem2Grade());
           privatedtos.add(dto);
       }
       return privatedtos;
    }

 
}
