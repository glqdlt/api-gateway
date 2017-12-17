package com.glqdlt.myhome.apigateway.service;


import com.glqdlt.myhome.apigateway.domain.ServerObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServerAddressService {

    public Map<String,ServerObject> getServerAddress() {

        ServerObject bookManager = new ServerObject();
        bookManager.setServerName("book-manager");
        bookManager.setServerUrl("http://127.0.0.1");

        Map<String, ServerObject> map = new HashMap<>();
        map.put("book-manager",bookManager);

        return map;


    }
}
