package com.glqdlt.myhome.apigateway.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestLog {

    @Id
    @GeneratedValue
    private int no;
    private String user_ip_address;
    private Date user_requestTime;
    private String request_payload;

}
