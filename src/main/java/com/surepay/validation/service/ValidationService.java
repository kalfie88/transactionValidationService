package com.surepay.validation.service;

import com.surepay.validation.entities.RecordRequest;

import javax.validation.Valid;
import java.util.List;

public interface ValidationService {

    void validate(@Valid List<RecordRequest> request);

}
