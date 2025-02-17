package service.custom.impl;

import dao.DaoFactory;
import dao.custom.LoginDao;
import dto.Logindto;
import entity.LoginEntity;
import service.custom.LoginService;

public class LoginServiceImpl implements LoginService {
      private LoginDao loginDao=(LoginDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.LOGIN);
    @Override
    public String save(Logindto logindto) throws Exception {
        LoginEntity loginEntity=new LoginEntity(logindto.getName(), logindto.getPassword());
        boolean isSaved=loginDao.save(loginEntity);
        return isSaved? "Success":"fail";
    }
    @Override
    public Logindto search(String name) throws Exception {
        LoginEntity loginEntity=loginDao.search(name);
        if (loginEntity!=null) {
            return new Logindto(loginEntity.getName(), loginEntity.getPassword());
        }
        return null;
    }

}
