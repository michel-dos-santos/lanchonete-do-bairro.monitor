package br.com.lanchonete.rest.controllers.base.dto;

import br.com.lanchonete.model.BillingFormType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBillingDTO {

    private UUID billingOrderId;
    private BigDecimal totalPrice;
    private BillingFormType billingFormType;

}
