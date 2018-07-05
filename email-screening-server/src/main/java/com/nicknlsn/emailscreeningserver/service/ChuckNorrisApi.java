package com.nicknlsn.emailscreeningserver.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ChuckNorrisApi {

    private final String SCHEME = "http";
    private final String HOST = "api.chucknorris.io";
    private final RestTemplate restTemplate;

    public ChuckNorrisApi() {
        this.restTemplate = new RestTemplate();
    }

    public String byCategory(String category) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(SCHEME).host(HOST).path("jokes/random").queryParam("category", category).build();
        String url = uriComponents.toUriString();
        System.out.println(url);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String joke = String.valueOf(responseEntity.getBody());

        return joke;
    }

    public String query(String query) {
        return null;
    }
}
