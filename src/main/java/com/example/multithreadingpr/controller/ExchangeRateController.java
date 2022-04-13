package com.example.multithreadingpr.controller;

import com.example.multithreadingpr.entity.InternationalExchangeRate;
import com.example.multithreadingpr.services.multithreading.ExchangeRateMultiAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateMultiAction exchangeRateMultiAction;

    @GetMapping
    public void getExchangeRate() {
        List<InternationalExchangeRate> internationalExchangeRates = exchangeRateMultiAction.performTasks();
        log.info("list" + internationalExchangeRates);
    }

}
