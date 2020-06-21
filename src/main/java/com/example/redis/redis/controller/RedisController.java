package com.example.redis.redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class RedisController {

    @GetMapping("/request")
    public String getCookie(HttpSession session) {
        String redisSessionId = session.getId();
        session.setAttribute("ID", "cheoljin_lee");
        log.info("set userId = {}","cheoljin_lee");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders header = new HttpHeaders();
        header.add("Cookie", "SESSION="+redisSessionId);
        HttpEntity<String> requestEntity = new HttpEntity<>(null, header);

        ResponseEntity<String> cookieValue = restTemplate.exchange("http://localhost:8090/request", HttpMethod.GET ,requestEntity ,String.class);
        return "server1_sessionKey : "+session.getId()+"<br>server2_sessionKey : "+cookieValue.getBody();
    }
}
