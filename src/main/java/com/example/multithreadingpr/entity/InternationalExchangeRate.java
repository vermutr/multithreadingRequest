package com.example.multithreadingpr.entity;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class InternationalExchangeRate {

    private String country;
    private String rate;

}
