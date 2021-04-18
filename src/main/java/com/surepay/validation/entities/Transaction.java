package com.surepay.validation.entities;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Value
@Builder
@Table(name = "transactions")
@EntityListeners({AuditingEntityListener.class})
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @NotNull
    Long reference;
}
