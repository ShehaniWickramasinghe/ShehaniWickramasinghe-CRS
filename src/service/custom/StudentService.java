package service.custom;

import dto.Studentdto;

public interface StudentService {
        public String save(Studentdto studentdto)throws Exception;
        public String update(Studentdto studentdto)throws Exception;
        public String delete(String studentId)throws Exception;
        public Studentdto search(String studentId)throws Exception;
}
