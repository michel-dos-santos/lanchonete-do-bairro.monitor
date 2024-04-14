package br.com.lanchonete.rest.controllers.base.dto;

import br.com.lanchonete.rest.controllers.base.enumerate.StatusPaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestConsumerDTO {

    private StatusPaymentType statusPaymentType;

}
