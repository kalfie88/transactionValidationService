package com.surepay.validation.entities;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Value
@Builder
@Table(name = "failed_validations")
@EntityListeners({AuditingEntityListener.class})
public class Record {

    @Id
    @NotNull
    @Column(name = "reference")
    Long reference;

    @Size(max = 300)
    @Column(name = "description", length = 300)
    String description;

}
