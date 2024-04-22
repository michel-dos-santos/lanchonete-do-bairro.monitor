package br.com.lanchonete.rest.controllers.itau.dto;

import br.com.lanchonete.rest.controllers.base.dto.RequestConsumerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItauRequestDTO extends RequestConsumerDTO {

    private UUID orderId;
    private BigDecimal totalPrice;

}
