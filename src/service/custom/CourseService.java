package service.custom;

import dto.Coursedto;
import dto.Studentdto;
import java.util.ArrayList;
import java.util.List;
import service.SuperService;

public interface CourseService extends SuperService {
        public String save(Coursedto coursedto, List<Studentdto>studentList)throws Exception;
        public String update(Coursedto coursedto)throws Exception;
        public Coursedto search(String courseId)throws Exception;
        public String delete(String courseId)throws Exception;
        public ArrayList<Coursedto> getAll()throws Exception;
        List<Coursedto> getAllCourses() throws Exception;
}
