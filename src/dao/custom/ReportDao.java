package dao.custom;

import dao.CrudDao;
import entity.ReportEntity;

public interface ReportDao extends CrudDao<ReportEntity, String> {
    public ReportEntity findById(String studentId, String semester, String course) throws Exception;    
}
