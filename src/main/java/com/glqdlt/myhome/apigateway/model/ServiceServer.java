package com.glqdlt.myhome.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceServer {

    private String ServerName;
    private String ServerUrl;
}
