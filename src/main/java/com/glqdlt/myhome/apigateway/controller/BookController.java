package com.glqdlt.myhome.apigateway.controller;


import com.glqdlt.myhome.apigateway.service.ServerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    ServerAddressService serverAddressService;

    private final String bookServerUrl;

    public BookController() {
        this.bookServerUrl = serverAddressService.getServerAddress().get("book-manager").getServerUrl();
    }

    @RequestMapping(value = "/book/search/all", method = RequestMethod.GET)
    public ResponseEntity<List<?>> bookSearch() {
        List<?> list = new ArrayList<>();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/search/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> bookSearchPage(@PathVariable int page) {
        Map<String, Object> map = new HashMap<>();
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value="/book/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> bookDetail(@PathVariable int id){

        List<?> list = new ArrayList<>();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/book/write", method = RequestMethod.PUT)
    public ResponseEntity<Integer> bookWrite(@RequestBody Object bookEntity) {

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}
