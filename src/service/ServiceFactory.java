package service;

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
           return null;
    }

    public enum ServiceType{

    }
}
