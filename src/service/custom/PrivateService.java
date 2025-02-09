package service.custom;

import dto.Privatedto;
import java.util.ArrayList;
import service.SuperService;

public interface PrivateService extends SuperService{
        public String save(Privatedto privatedto)throws Exception;
        public String update(Privatedto privatedto)throws Exception;
        public Privatedto search(String id)throws Exception;
        public ArrayList<Privatedto> getAll()throws Exception; 
}
