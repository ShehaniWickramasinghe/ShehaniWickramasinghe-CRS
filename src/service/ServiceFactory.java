package service;

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
            default:
                return null;
           }
    }

    public enum ServiceType{
            STUDENT,REPORT
    }
}
