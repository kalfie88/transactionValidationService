package com.surepay.validation.repository;

import com.surepay.validation.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Record, Long> {
}
