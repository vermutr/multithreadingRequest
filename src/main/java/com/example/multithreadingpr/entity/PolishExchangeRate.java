package com.example.multithreadingpr.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PolishExchangeRate {

    private LocalDate data;
    private String cena;

}
