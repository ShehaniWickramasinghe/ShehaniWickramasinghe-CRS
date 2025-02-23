package service.custom;

import dto.Logindto;
import service.SuperService;

public interface LoginService extends SuperService{
        public String save(Logindto logindto)throws Exception; 
        public Logindto search(String name)throws Exception;
        public String delete(String name)throws Exception;
}       
        
