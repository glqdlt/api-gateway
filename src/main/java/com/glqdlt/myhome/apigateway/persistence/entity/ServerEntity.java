package com.glqdlt.myhome.apigateway.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerEntity {

    private String serverName;
    private String serverUrl;

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Data
    @Entity
    public static class LogEntity {


        @Id
        @GeneratedValue
        private int no;
        private String userIpAddress;
        private Date userRequestTime;
        private String requestPayload;

    }
}
