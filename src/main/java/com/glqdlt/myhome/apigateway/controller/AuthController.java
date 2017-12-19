package com.glqdlt.myhome.apigateway.controller;

import com.glqdlt.myhome.apigateway.service.RestDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private RestDeliveryService restDeliveryService;

    @RequestMapping(value = "/exp", method = RequestMethod.POST)
    public ResponseEntity<Integer> expireToken() {
        return new ResponseEntity<>(Integer.parseInt(restDeliveryService.expToken().toString()), HttpStatus.OK);
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public ResponseEntity<Object> isLogin(@RequestBody Object loginUser) {
            log.info(loginUser.toString());
        return new ResponseEntity<>(restDeliveryService.isLogin(loginUser), HttpStatus.OK);
    }

}
