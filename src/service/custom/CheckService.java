package service.custom;

import dto.Checkdto;
import service.SuperService;

public interface CheckService extends SuperService{
      public Checkdto search(String name)throws Exception;  
}
