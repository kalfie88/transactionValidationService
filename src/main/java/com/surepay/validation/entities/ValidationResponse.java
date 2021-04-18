package com.surepay.validation.entities;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ValidationResponse {

    Long referenceNumber;
    String description;

}
