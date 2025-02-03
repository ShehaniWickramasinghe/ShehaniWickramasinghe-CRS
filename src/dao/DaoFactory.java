package dao;

import dao.custom.impl.ReportDaoImpl;
import dao.custom.impl.StudentDaoImpl;

public class DaoFactory {
        private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance(){
        if (daoFactory==null) {
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType type){
        switch (type) {
            case STUDENT:
                return new StudentDaoImpl();
            case REPORT:
                return new ReportDaoImpl();   
            default:
                throw new AssertionError();
        }
    }
    
    public enum DaoType{
        STUDENT,REPORT
    }
}
