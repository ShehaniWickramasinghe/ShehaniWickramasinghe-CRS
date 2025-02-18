package service.custom;

import dto.CourseReportdto;
import java.util.ArrayList;
import service.SuperService;

public interface CourseReportService  extends SuperService{
        public String save(CourseReportdto courseReportdto)throws Exception;
        public String update(CourseReportdto courseReportdto)throws Exception;
        public CourseReportdto search(String name)throws Exception;
        public ArrayList<CourseReportdto> getAll()throws Exception; 
}
