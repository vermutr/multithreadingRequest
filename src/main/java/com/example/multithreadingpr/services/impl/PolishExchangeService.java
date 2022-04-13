package com.example.multithreadingpr.services.impl;

import com.example.multithreadingpr.entity.InternationalExchangeRate;
import com.example.multithreadingpr.entity.PolishExchangeRate;
import com.example.multithreadingpr.services.ExchangeRateRestTemplate;
import com.example.multithreadingpr.util.ConverterRestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PolishExchangeService implements ExchangeRateRestTemplate {

    @Value("${api.polish.exchangerate}")
    private String url;

    private final ConverterRestTemplate converterRestTemplate;

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<List<InternationalExchangeRate>> getExchangeRateFromRestTemplate() {
        log.info("current thread " + Thread.currentThread().getName());
        List<InternationalExchangeRate> collect = Arrays.stream(converterRestTemplate.getJsonObject(url, PolishExchangeRate[].class))
                .map(this::mapExchangeRate)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(collect);
    }

    private InternationalExchangeRate mapExchangeRate(PolishExchangeRate polishExchangeRate) {
        return new InternationalExchangeRate("Poland", polishExchangeRate.getCena());
    }

}
