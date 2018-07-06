package com.nicknlsn.emailscreeningserver.service;

import com.nicknlsn.emailscreeningserver.model.ChuckNorrisJoke;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ChuckNorrisApi {

    private final String SCHEME = "https";
    private final String HOST = "api.chucknorris.io";
    private final RestTemplate restTemplate;
    private final HttpEntity<String> httpEntity;

    public ChuckNorrisApi() {
        this.restTemplate = new RestTemplate();

        // looks like there is a user-agent restriction on the api
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
        httpEntity = new HttpEntity<>("parameters", httpHeaders);
    }

    List<String> getCategories() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(SCHEME).host(HOST).path("jokes/categories").build();
        String url = uriComponents.toUriString();

        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<String>>() {
        });

        return responseEntity.getBody();
    }

    String byCategory(String category) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(SCHEME).host(HOST).path("jokes/random").queryParam("category", category).build();
        String url = uriComponents.encode().toUriString();
        System.out.println(url);

        ResponseEntity<ChuckNorrisJoke> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                ChuckNorrisJoke.class);
        ChuckNorrisJoke chuckNorrisJoke = responseEntity.getBody();

        return chuckNorrisJoke.getValue();
    }

    public String query(String query) {
        return null;
    }
}
