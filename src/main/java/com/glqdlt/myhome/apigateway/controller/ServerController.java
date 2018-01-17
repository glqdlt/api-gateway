package com.glqdlt.myhome.apigateway.controller;

import com.glqdlt.myhome.apigateway.service.RestDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/server")
public class ServerController {

    @Autowired
    RestDeliveryService restDeliveryService;

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public ResponseEntity<Object[]> getServerAll() {

        return new ResponseEntity<>(restDeliveryService.serverSearchAll(), HttpStatus.OK);
    }
}
