package com.surepay.validation.service;

import com.surepay.validation.entities.ValidationResponse;

import java.util.List;

public interface ReportService {

    List<ValidationResponse> getReport();
}
