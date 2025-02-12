package service.custom.impl;

import dao.DaoFactory;
import dao.custom.PrivateDao;
import dao.custom.ReportDao;
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
    public String update(Privatedto privatedto) throws Exception {
        PrivateEntity privateEntity=new PrivateEntity(privatedto.getId(), privatedto.getName(), privatedto.getDepartment(),
        privatedto.getAttendance(),privatedto.getSem1Grade(),privatedto.getSem2Grade());

        boolean isUpdate=privateDao.update(privateEntity);
        return isUpdate ? "Success":"fail";
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

    @Override
    public String placeOrder(Privatedto privatedto, List<Reportdto> reportList) throws Exception {
        Connection connection=null;
        try {
            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false); // Step 1: Start Transaction
    
            String studentId = privatedto.getId();
            boolean studentExists = (privateDao.search(privatedto.getId()) != null);
        if (privateDao.search(studentId) == null) {
            connection.rollback();
            return "Error: Student does not exist!";
        }

            PrivateEntity privateEntity = new PrivateEntity(
                privatedto.getId(), 
                privatedto.getName(), 
                privatedto.getDepartment(),
                privatedto.getAttendance(), 
                privatedto.getSem1Grade(), 
                privatedto.getSem2Grade()
            );

            boolean isPrivateSuccess;
        if (studentExists) {
            // 🔹 Update if student exists
            isPrivateSuccess = privateDao.update(privateEntity);
        } else {
            // 🔹 Save if student does not exist
            isPrivateSuccess = privateDao.save(privateEntity);
        }

    
            if (!isPrivateSuccess) {
                connection.rollback();  // If privateDao.save() fails, rollback
                return "Failed to save/update PrivateEntity";
            }
    
   
            for (Reportdto reportDto : reportList) {
                ReportEntity reportEntity = new ReportEntity(
                    reportDto.getStudentId(),
                    reportDto.getStudentName(),
                    reportDto.getDepartment(),
                    reportDto.getCourse(),
                    reportDto.getSemester(),
                    reportDto.getGrade()
                );
    
                boolean reportExists = !reportDao.searchAll(reportDto.getStudentId()).isEmpty();

                boolean isReportSuccess;
                if (reportExists) {
                    isReportSuccess = reportDao.update(reportEntity);
                } else {
                    isReportSuccess = reportDao.save(reportEntity);
                }
            if (!isReportSuccess) {
                connection.rollback();
                return "Failed to save/update ReportEntity!";
            }
            }
    
            connection.commit(); 
            return "Success";
    
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback(); // 🔹 Rollback if error occurs
                } catch (Exception rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            connection.rollback();  
            e.printStackTrace();
            return "Transaction failed: " + e.getMessage();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // 🔹 Reset AutoCommit
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
        }
    }
    
     } 
}
