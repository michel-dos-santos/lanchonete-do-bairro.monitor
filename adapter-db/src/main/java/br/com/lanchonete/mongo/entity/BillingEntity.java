package br.com.lanchonete.mongo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BillingEntity {

    @Id
    @GeneratedValue
    private String id;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Column(columnDefinition = "uuid")
    private UUID orderId;
    @Column(length = 14, scale = 2)
    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private StatusPaymentType status;
    @Enumerated(EnumType.STRING)
    private BillingFormType billingFormType;

}
