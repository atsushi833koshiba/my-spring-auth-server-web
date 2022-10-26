package com.example.myspringauthserverweb.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizationEndpointRequest {

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("state")
    private String state;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("response_type")
    @Pattern(regexp = "code")
    private String response_type;

    @JsonProperty("response_type")
    @Pattern(regexp = "openid")
    private String scope;

}
