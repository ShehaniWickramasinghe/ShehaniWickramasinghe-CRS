package service.custom;

import dto.Logindto;
import dto.Studentdto;
import java.util.ArrayList;
import java.util.List;
import service.SuperService;

public interface StudentService extends SuperService {
        public String save(Studentdto studentdto, List<Logindto>loginList)throws Exception;
        public String update(Studentdto studentdto)throws Exception;
        public String delete(String studentId)throws Exception;
        public Studentdto search(String studentId)throws Exception;
        public ArrayList<Studentdto> getAll() throws Exception;
}
