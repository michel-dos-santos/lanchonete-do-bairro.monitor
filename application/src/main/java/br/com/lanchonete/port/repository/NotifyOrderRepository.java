package br.com.lanchonete.port.repository;

import br.com.lanchonete.model.StatusPaymentType;

import java.util.UUID;

public interface NotifyOrderRepository {

    void sendNotification(StatusPaymentType statusPaymentType, UUID billingOrderId);

}
