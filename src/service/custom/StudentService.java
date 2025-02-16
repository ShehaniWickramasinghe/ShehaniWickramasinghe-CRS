package service.custom;

import dto.Studentdto;
import java.util.ArrayList;
import service.SuperService;

public interface StudentService extends SuperService {
        public String save(Studentdto studentdto)throws Exception;
        public String update(Studentdto studentdto)throws Exception;
        public String delete(String studentId)throws Exception;
        public Studentdto search(String studentId)throws Exception;
        public ArrayList<Studentdto> getAll() throws Exception;
}
