package com.glqdlt.myhome.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookRestService {


    private final String bookServerUrl;
    private final RestTemplate restTemplate;

    public BookRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.bookServerUrl = ServerAddressService.getInstance().getServerAddress().get("book-manager").getServerUrl();
    }

    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }

    public Object[] bookSearchAll() {
        return this.restTemplate.getForObject(this.bookServerUrl + "/book/search/all", Object[].class
        );
    }

    public Object bookSearchPage(int page) {
        return this.restTemplate.getForObject(this.bookServerUrl + "/book/search/" + page, Object.class);
    }

    public Object bookSearchDetail(int id) {
        return this.restTemplate.getForObject(this.bookServerUrl + "/book/detail/" + id, Object.class);
    }

    public void writeNewBook(Object newBook){
        this.restTemplate.put(this.bookServerUrl+"/book/write",newBook);
    }
}
