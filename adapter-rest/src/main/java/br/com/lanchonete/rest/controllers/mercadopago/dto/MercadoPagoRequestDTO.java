package br.com.lanchonete.rest.controllers.mercadopago.dto;

import br.com.lanchonete.rest.controllers.base.dto.RequestConsumerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MercadoPagoRequestDTO extends RequestConsumerDTO {

    private UUID orderId;
    private BigDecimal totalPrice;

}
