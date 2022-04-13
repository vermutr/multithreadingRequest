package com.example.multithreadingpr.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ConverterRestTemplate {

    private final RestTemplate restTemplate;

    public <T> T getJsonObject(String url, final Class<T> clazz) {
        return restTemplate.getForObject(url, clazz);
    }

}
