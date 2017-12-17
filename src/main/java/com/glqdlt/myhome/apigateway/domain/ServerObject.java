package com.glqdlt.myhome.apigateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerObject {

    private String serverName;
    private String serverUrl;

}
