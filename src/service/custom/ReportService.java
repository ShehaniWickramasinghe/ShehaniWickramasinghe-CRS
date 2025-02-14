package service.custom;

import dto.Reportdto;
import java.util.List;
import service.SuperService;

public interface ReportService extends SuperService {
        public List<Reportdto> search(String StudentId)throws Exception;
        public String update(Reportdto reportdto)throws Exception;
}
