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

        ServerEntity crawManager = new ServerEntity();
        crawManager.setServerName("craw-manager");
        crawManager.setServerUrl("http://127.0.0.1:28888");

        Map<String, ServerEntity> map = new HashMap<>();
        map.put("book-manager",bookManager);
        map.put("craw-manager",crawManager);
        return map;
    }

    private static class LazyHolder {

        public static final ServerAddressService INSTACE = new ServerAddressService();

    }
}
