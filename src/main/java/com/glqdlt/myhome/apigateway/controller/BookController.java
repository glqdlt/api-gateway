package com.glqdlt.myhome.apigateway.controller;


import com.glqdlt.myhome.apigateway.service.BookRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookRestService bookRestService;

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public ResponseEntity<Object[]> bookSearch() {
        return new ResponseEntity<>(bookRestService.bookSearchAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
    public ResponseEntity<Object> bookSearchPage(@PathVariable int page) {
        return new ResponseEntity<>(bookRestService.bookSearchPage(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> bookDetail(@PathVariable int id) {

        List<?> list = new ArrayList<>();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/write", method = RequestMethod.PUT)
    public ResponseEntity<Integer> bookWrite(@RequestBody Object bookEntity) {

        this.bookRestService.writeNewBook(bookEntity);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}
