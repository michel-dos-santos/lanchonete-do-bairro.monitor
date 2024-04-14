package br.com.lanchonete.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Billing {

    private UUID id;
    private Date createdAt;
    private Date updatedAt;
    private UUID billingOrderId;
    private BigDecimal totalPrice;
    private StatusPaymentType status;
    private BillingFormType billingFormType;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UUID getBillingOrderId() {
        return billingOrderId;
    }

    public void setBillingOrderId(UUID billingOrderId) {
        this.billingOrderId = billingOrderId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public StatusPaymentType getStatus() {
        return status;
    }

    public void setStatus(StatusPaymentType status) {
        this.status = status;
    }

    public BillingFormType getBillingFormType() {
        return billingFormType;
    }

    public void setBillingFormType(BillingFormType billingFormType) {
        this.billingFormType = billingFormType;
    }
}
