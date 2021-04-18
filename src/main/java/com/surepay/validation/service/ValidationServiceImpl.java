package com.surepay.validation.service;

import com.surepay.validation.entities.Record;
import com.surepay.validation.entities.RecordRequest;
import com.surepay.validation.entities.Transaction;
import com.surepay.validation.exceptions.BadRequestException;
import com.surepay.validation.repository.TransactionRepository;
import com.surepay.validation.repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;


@Service
@AllArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final ValidationRepository validationRepository;
    private final TransactionRepository transactionRepository;

    /**
     * @param request records to be validated
     */
    public void validate(@Valid List<RecordRequest> request) {
        request.forEach(this::validateRequest);

        //per record the end balance needs to be correct given the start balance and mutation
        request.forEach(r -> {
            if (r.getEndBalance() + r.getMutation() != r.getMutation()) {
                validationRepository.save(Record.builder()
                        .reference(r.getReference())
                        .description(r.getDescription())
                        .build());

                transactionRepository.save(Transaction.builder()
                        .reference(r.getReference())
                        .build());
            }
        });

    }

    /**
     * Method to valid the request
     *
     * @param request request to be validated
     */
    private void validateRequest(RecordRequest request) {
        if (request == null || request.getReference() == null || request.getAccountNumber() == null || request.getDescription() == null)
            throw new BadRequestException();
    }
}
