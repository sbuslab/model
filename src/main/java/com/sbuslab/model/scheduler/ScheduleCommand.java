package com.sbuslab.model.scheduler;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleCommand {

    private String scheduleId;

    private Long atTime;

    private Long period;

    @NotNull
    private String routingKey;

    private Object body;

    private String origin;

    private String signature;
}
