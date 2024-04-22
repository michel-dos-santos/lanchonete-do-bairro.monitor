package br.com.lanchonete.usecase;

import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.model.StatusPaymentType;
import br.com.lanchonete.port.repository.BillingRepository;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.NotifyOrderRepository;
import br.com.lanchonete.port.usecase.UpdateBillingByHub;

import java.util.UUID;

public class UpdateBillingByHubUsecase implements UpdateBillingByHub {

    private final LogRepository logRepository;
    private final BillingRepository billingRepository;
    private final NotifyOrderRepository notifyOrderRepository;

    public UpdateBillingByHubUsecase(LogRepository logRepository, BillingRepository billingRepository, NotifyOrderRepository notifyOrderRepository) {
        this.logRepository = logRepository;
        this.billingRepository = billingRepository;
        this.notifyOrderRepository = notifyOrderRepository;
    }

    @Override
    public void updateStatusPaymentType(StatusPaymentType statusPaymentType, UUID orderId) {
        logRepository.info(UpdateBillingByHubUsecase.class, LogCode.LogCodeInfo._0035);
        billingRepository.updateStatusPaymentType(orderId, statusPaymentType);
        notifyOrderRepository.sendNotification(statusPaymentType, orderId);
        logRepository.info(UpdateBillingByHubUsecase.class, LogCode.LogCodeInfo._0036);
    }
}
