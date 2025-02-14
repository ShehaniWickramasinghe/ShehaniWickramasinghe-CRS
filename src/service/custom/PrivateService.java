package service.custom;

import dto.Privatedto;
import dto.Reportdto;
import java.util.ArrayList;
import java.util.List;
import service.SuperService;

public interface PrivateService extends SuperService{
        public String save(Privatedto privatedto,List<Reportdto> reportList)throws Exception;
        public String update(Privatedto privatedto, List<Reportdto> reportList)throws Exception;
        public Privatedto search(String id)throws Exception;
        public ArrayList<Privatedto> getAll()throws Exception; 
       
}
