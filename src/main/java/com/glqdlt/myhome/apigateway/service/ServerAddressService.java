package com.glqdlt.myhome.apigateway.service;


import com.glqdlt.myhome.apigateway.model.ServiceServer;

import java.util.HashMap;
import java.util.Map;

public class ServerAddressService {


    private ServerAddressService() {
    }

    public static ServerAddressService getInstance(){
        return LazyHolder.INSTANCE;
    }

    public Map<String,ServiceServer> getServerAddress() {

        ServiceServer bookManager = new ServiceServer();
        bookManager.setServerName("book-manager");
        bookManager.setServerUrl("http://127.0.0.1:38080");

        ServiceServer crawManager = new ServiceServer();
        crawManager.setServerName("craw-manager");
        crawManager.setServerUrl("http://127.0.0.1:28888");

        ServiceServer authManager = new ServiceServer();
        authManager.setServerName("auth-manager");
        authManager.setServerUrl("http://127.0.0.1:18888");

        Map<String, ServiceServer> map = new HashMap<>();
        map.put("book-manager",bookManager);
        map.put("craw-manager",crawManager);
        map.put("auth-manager",authManager);
        return map;
    }

    private static class LazyHolder {

        public static final ServerAddressService INSTANCE = new ServerAddressService();

    }
}
