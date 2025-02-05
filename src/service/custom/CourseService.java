package service.custom;

import dto.Coursedto;
import java.util.ArrayList;
import service.SuperService;

public interface CourseService extends SuperService {
        public String save(Coursedto coursedto)throws Exception;
        public String update(Coursedto coursedto)throws Exception;
        public Coursedto search(String courseId)throws Exception;
        public String delete(String courseId)throws Exception;
        public ArrayList<Coursedto> getAll()throws Exception;
}
