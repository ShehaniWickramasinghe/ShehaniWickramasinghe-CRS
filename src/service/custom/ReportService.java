package service.custom;

import dto.Reportdto;
import service.SuperService;

public interface ReportService extends SuperService {
        public Reportdto search(String StudentId)throws Exception;
}
