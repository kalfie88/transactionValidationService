package com.surepay.validation.entities;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Value
@Builder
public class RecordRequest {

    @NotNull
    Long reference;

    String accountNumber;

    @Max(300)
    String description;

    double startBalance;

    double mutation;

    double endBalance;

}
