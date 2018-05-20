package com.sbuslab.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Range {
    private BigDecimal from;
    private BigDecimal to;

    public Range(Long from, Long to) {
        this(from != null ? new BigDecimal(from) : null, to != null ? new BigDecimal(to) : null);
    }
}
