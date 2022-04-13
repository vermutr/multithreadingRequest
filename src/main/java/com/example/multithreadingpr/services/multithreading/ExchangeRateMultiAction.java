package com.example.multithreadingpr.services.multithreading;

import com.example.multithreadingpr.entity.InternationalExchangeRate;
import com.example.multithreadingpr.services.ExchangeRateRestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateMultiAction {

    private final List<ExchangeRateRestTemplate> exchangeRateRestTemplate;

    public List<InternationalExchangeRate> performTasks() {
        return exchangeRateRestTemplate.stream()
                .map(ExchangeRateRestTemplate::getExchangeRateFromRestTemplate)
                .map(CompletableFuture::join)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
