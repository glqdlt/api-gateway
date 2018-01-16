package com.glqdlt.myhome.apigateway.service;

import com.glqdlt.myhome.apigateway.model.Token;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;

@Service
public class RestDeliveryService {

    @Value("${book-manager.url}")
    private String bookServerUrl;

    @Value("${craw-manager.url}")
    private String crawServerUrl;

    @Value("${auth-manager.url")
    private String authServerUrl;
    private final RestTemplate restTemplate;


    public RestDeliveryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /* Book  Manager*/
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

    public void writeNewBook(Object newBook) {
        this.restTemplate.put(this.bookServerUrl + "/book/write", newBook);
    }

    public void bookUpdate(int id, Object bookEntity) {this.restTemplate.put(this.bookServerUrl+"/book/update/"+id,bookEntity);}


    /* Craw Manager*/
    public Object[] crawSearchAll() {
        return this.restTemplate.getForObject(this.crawServerUrl + "/craw/all", Object[].class);
    }

    public Object crawSearchPage(int page) {
        return this.restTemplate.getForObject(this.crawServerUrl + "/craw/" + page, Object.class);
    }


    /* Auth Manager */
    // TODO 실제 Authmanager 개발, 그리고 여기의 딜리버리 로직 구현 필요.

    public Object isLogin(Object loginUser) {
//        return this.restTemplate.postForObject(this.authServerUrl+"/isLogin",Object.class);
        Token token = new Gson().fromJson(loginUser.toString(), Token.class);
        return new Token("dummy", new Date(makeExpireDate().getTimeInMillis()), "refresh", token.getUsername());
    }

    private Calendar makeExpireDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 7);
        return calendar;
    }

    public Object expToken() {
//        Object request = null;
//        return this.restTemplate.postForEntity(this.authServerUrl + "exp", request, Object.class);
        return 1;

    }

}
