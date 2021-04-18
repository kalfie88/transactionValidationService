package com.surepay.validation.controller;

import com.surepay.validation.entities.RecordRequest;
import com.surepay.validation.entities.ValidationResponse;
import com.surepay.validation.service.ReportServiceImpl;
import com.surepay.validation.service.ValidationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ValidationController {

    private final ValidationServiceImpl validationService;
    private final ReportServiceImpl reportServiceImpl;

    @PostMapping("/validate")
    @ResponseStatus(HttpStatus.OK)
    public void validateRecords(@Valid @RequestBody List<RecordRequest> request) {
        validationService.validate(request);
    }

    @GetMapping("/report")
    public List<ValidationResponse> getReport() {
        return reportServiceImpl.getReport();
    }


}
