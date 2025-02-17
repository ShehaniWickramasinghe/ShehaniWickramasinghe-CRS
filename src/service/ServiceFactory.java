package service;

import service.custom.impl.CheckServiceImpl;
import service.custom.impl.CourseServiceImpl;
import service.custom.impl.LoginServiceImpl;
import service.custom.impl.PrivateServiceImpl;
import service.custom.impl.ReportServiceImpl;
import service.custom.impl.StudentServiceImpl;

public class ServiceFactory {
        private static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        if (serviceFactory==null) {
            serviceFactory=new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService(ServiceType type){
           switch (type) {
            case STUDENT:
                return new StudentServiceImpl();
            case REPORT:
                return new ReportServiceImpl(); 
            case COURSE:
                return new CourseServiceImpl(); 
            case PRIVATE:
                return new PrivateServiceImpl();   
            case CHECK:
                return new CheckServiceImpl(); 
            case LOGIN:
                return new LoginServiceImpl();            
            default:
                return null;
           }
    }

    public enum ServiceType{
            STUDENT,REPORT,COURSE,PRIVATE,CHECK,LOGIN
    }
}
