
package com.sbuslab.model;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paging {

    private Long offset;

    @Max(1000)
    private Long limit;
}
