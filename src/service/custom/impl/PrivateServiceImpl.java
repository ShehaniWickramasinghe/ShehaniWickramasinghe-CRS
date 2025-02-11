package service.custom.impl;

import dao.DaoFactory;
import dao.custom.PrivateDao;
import dto.Privatedto;
import entity.PrivateEntity;
import java.util.ArrayList;
import service.custom.PrivateService;

public class PrivateServiceImpl implements PrivateService{
            private PrivateDao privateDao=(PrivateDao)DaoFactory.getInstance().getDao(DaoFactory.DaoType.PRIVATE);
    @Override
    public String save(Privatedto privatedto) throws Exception {
        PrivateEntity privateEntity=new PrivateEntity(privatedto.getId(), privatedto.getName(),
        privatedto.getDepartment(),privatedto.getAttendance(), privatedto.getSem1Grade(), privatedto.getSem2Grade());

        boolean isSaved=privateDao.save(privateEntity);
        return isSaved ? "Success":"fail";
    }

    @Override
    public String update(Privatedto privatedto) throws Exception {
        PrivateEntity privateEntity=new PrivateEntity(privatedto.getId(), privatedto.getName(), privatedto.getDepartment(),
        privatedto.getAttendance(),privatedto.getSem1Grade(),privatedto.getSem2Grade());

        boolean isUpdate=privateDao.update(privateEntity);
        return isUpdate ? "Success":"fail";
    }

    @Override
    public Privatedto search(String id) throws Exception {
        PrivateEntity privateEntity=privateDao.search(id);
        if (privateEntity!=null) {
            return new Privatedto(privateEntity.getId(), privateEntity.getName(), privateEntity.getDepartment(), privateEntity.getAttendance(),
            privateEntity.getSem1Grade(),privateEntity.getSem2Grade());

        }
        return null;
    }

    @Override
    public ArrayList<Privatedto> getAll() throws Exception {
       ArrayList<Privatedto> privatedtos=new ArrayList<>();
       ArrayList<PrivateEntity> privateEntities=privateDao.getAll();
       for (PrivateEntity privateEntity : privateEntities) {
           Privatedto dto=new Privatedto(
        privateEntity.getId(),privateEntity.getName(),privateEntity.getDepartment(),
           privateEntity.getAttendance(),
           privateEntity.getSem1Grade(),privateEntity.getSem2Grade());
           privatedtos.add(dto);
       }
       return privatedtos;
    }

}
