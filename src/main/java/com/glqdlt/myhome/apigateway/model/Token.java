package com.glqdlt.myhome.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Token {

    private String token;
    private Date exp;
    private String refresh_token;

}
