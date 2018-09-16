package com.sbuslab.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sorting {

    @NotNull
    private String field;

    private String rawSql;

    private String value;

    @NotNull
    private SortingDirection direction;
}
