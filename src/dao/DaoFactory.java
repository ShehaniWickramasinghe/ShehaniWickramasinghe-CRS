package dao;

import dao.custom.impl.CheckDaoImpl;
import dao.custom.impl.CourseDaoImpl;
import dao.custom.impl.CourseReportDaoImpl;
import dao.custom.impl.LoginDaoImpl;
import dao.custom.impl.PrivateDaoImpl;
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
            case COURSE:
                return new CourseDaoImpl();  
            case PRIVATE:
                 return new PrivateDaoImpl(); 
            case CHECK:
                 return new CheckDaoImpl();  
            case LOGIN:
                return new LoginDaoImpl();   
            case COURSE_REPORT:
                return new CourseReportDaoImpl();             
            default:
                throw new AssertionError();
        }
    }
    
    public enum DaoType{
        STUDENT,REPORT,COURSE,PRIVATE,CHECK,LOGIN,COURSE_REPORT
    }
}
