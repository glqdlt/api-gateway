package com.glqdlt.myhome.apigateway.controller;


import com.glqdlt.myhome.apigateway.service.RestDeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    RestDeliveryService bookRestService;

    Logger logger = LoggerFactory.getLogger(BookController.class);


    @RequestMapping(value ="/tag/all",method=RequestMethod.GET)
    public ResponseEntity<Object[]> bookTagAll() {return new ResponseEntity<>(bookRestService.bookTagAll(), HttpStatus.OK);}

    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    public ResponseEntity<Object[]> bookSearch() {
        return new ResponseEntity<>(bookRestService.bookSearchAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/search/{page}", method = RequestMethod.GET)
    public ResponseEntity<Object> bookSearchPage(@PathVariable int page) {
        return new ResponseEntity<>(bookRestService.bookSearchPage(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> bookDetail(@PathVariable int id) {
        return new ResponseEntity<>(this.bookRestService.bookSearchDetail(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/write", method = RequestMethod.PUT)
    public ResponseEntity<Integer> bookWrite(@RequestBody Object bookEntity) {

        this.bookRestService.writeNewBook(bookEntity);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @RequestMapping(value ="/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Integer> bookUpdate(@PathVariable int id, @RequestBody Object bookEntity){
        this.bookRestService.bookUpdate(id,bookEntity);
        return new ResponseEntity<>(1,HttpStatus.OK);
    }

    @RequestMapping(value ="/remove/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Integer> bookRemove(@PathVariable int id){
        this.bookRestService.removeBook(id);
        return new ResponseEntity<>(1,HttpStatus.OK);
    }

    @RequestMapping(value="/download/{id}",method = RequestMethod.GET)
    public ResponseEntity<ByteArrayResource> bookDownload(@PathVariable int id){
        return this.bookRestService.bookDownload(id);
    }

    @RequestMapping(value="/search/tags/all",method = RequestMethod.GET)
    public ResponseEntity<Object> bookSearchAll(){
        return  new ResponseEntity<>(this.bookRestService.bookSearchTagAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "/search/subject/{subject}",method=RequestMethod.GET)
    public ResponseEntity<Object[]> bookSearchBySubject(@PathVariable String subject){
        return new ResponseEntity<>(this.bookRestService.bookSearchBySubject(subject),HttpStatus.OK);
    }


}
