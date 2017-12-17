package com.glqdlt.myhome.apigateway.controller;

import com.glqdlt.myhome.apigateway.service.RestDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/craw")
public class CrawController {

    @Autowired
    RestDeliveryService restDeliveryService;

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public ResponseEntity<Object[]> getCrawAll() {

        return new ResponseEntity<>(restDeliveryService.crawSearchAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
    public Object getCrawPage(@PathVariable int page) {

        return new ResponseEntity<>(restDeliveryService.crawSearchPage(page), HttpStatus.OK);
    }
}
