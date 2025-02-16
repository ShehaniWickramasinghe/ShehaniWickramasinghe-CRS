package service.custom.impl;

import dao.DaoFactory;
import dao.custom.CheckDao;
import dto.Checkdto;
import entity.CheckEntity;
import service.custom.CheckService;

public class CheckServiceImpl implements CheckService {
        private CheckDao checkDao=(CheckDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.CHECK);
    @Override
    public Checkdto search(String name) throws Exception {
       CheckEntity checkEntity=checkDao.check(name);

       if (checkEntity!=null) {
        return new Checkdto(checkEntity.getName(), checkEntity.getPrerequisites());
       }
       return null;
    }

}
