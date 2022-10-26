package com.example.myspringauthserverweb.controller;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationEndpointController {

    private static final String AUTHORIZATION_ENDPOINT_URI = "/authorize";

    @RequestMapping(method = RequestMethod.GET, value = AUTHORIZATION_ENDPOINT_URI)
    public ResponseEntity<Void> handleRequest(@ModelAttribute AuthorizationEndpointRequest request, BindingResult bindingResult) {

        // TODO handle validation error

        // TODO build url
        final String baseUrl = "http://localhost:8080";
        final String redirectUrl = buildRedirectUrl(baseUrl, request);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(redirectUrl)).build();
    }


    String buildRedirectUrl(String baseUrl, AuthorizationEndpointRequest request) {

        StringBuilder sb = new StringBuilder(baseUrl);
        sb.append("?");
        sb.append("client_id=");
        sb.append(request.getClientId());
        sb.append("&");
        sb.append("state=");
        sb.append(request.getState());
        sb.append("redirect=");
        sb.append(request.getRedirectUrl());
        sb.append("scope=");
        sb.append(String.join(" ", request.getScope()));
        return sb.toString();
    }
}
