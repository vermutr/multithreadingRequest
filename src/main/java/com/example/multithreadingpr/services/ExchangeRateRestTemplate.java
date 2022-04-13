package com.example.multithreadingpr.services;

import com.example.multithreadingpr.entity.InternationalExchangeRate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ExchangeRateRestTemplate {
    CompletableFuture<List<InternationalExchangeRate>> getExchangeRateFromRestTemplate();
}
