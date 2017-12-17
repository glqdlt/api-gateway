package com.glqdlt.myhome.apigateway.service;


import com.glqdlt.myhome.apigateway.persistence.entity.ServerEntity;

import java.util.HashMap;
import java.util.Map;

public class ServerAddressService {


    private ServerAddressService() {
    }

    public static ServerAddressService getInstance(){
        return LazyHolder.INSTACE;
    }

    public Map<String,ServerEntity> getServerAddress() {

        ServerEntity bookManager = new ServerEntity();
        bookManager.setServerName("book-manager");
        bookManager.setServerUrl("http://127.0.0.1:38080");

        Map<String, ServerEntity> map = new HashMap<>();
        map.put("book-manager",bookManager);
        return map;
    }

    private static class LazyHolder {

        public static final ServerAddressService INSTACE = new ServerAddressService();

    }
}
