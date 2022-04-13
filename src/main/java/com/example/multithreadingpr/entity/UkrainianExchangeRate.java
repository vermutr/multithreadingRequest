package com.example.multithreadingpr.entity;

import lombok.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class UkrainianExchangeRate {

    private String r030;
    private String txt;
    private String rate;
    private String cc;
    private String exchangedate;

}
