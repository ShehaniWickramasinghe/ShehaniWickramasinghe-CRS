package dao;

public class DaoFactory {
        private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public DaoFactory getInstance(){
        if (daoFactory==null) {
            daoFactory=new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoType type){
        return null;
    }
    
    public enum DaoType{
        
    }
}
