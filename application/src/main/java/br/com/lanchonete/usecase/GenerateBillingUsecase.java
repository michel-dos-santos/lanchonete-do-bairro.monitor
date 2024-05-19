package br.com.lanchonete.usecase;

import br.com.lanchonete.model.Billing;
import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.model.StatusPaymentType;
import br.com.lanchonete.port.repository.BillingRepository;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.usecase.GenerateBilling;

public class GenerateBillingUsecase implements GenerateBilling {

    private final LogRepository logRepository;
    private final BillingRepository billingRepository;

    public GenerateBillingUsecase(LogRepository logRepository, BillingRepository billingRepository) {
        this.logRepository = logRepository;
        this.billingRepository = billingRepository;
    }

    @Override
    public Billing generate(Billing billing) {
        logRepository.info(GenerateBillingUsecase.class, LogCode.LogCodeInfo._0002);
        billing.setStatus(StatusPaymentType.PENDING);
        billing = billingRepository.save(billing);
        logRepository.info(GenerateBillingUsecase.class, LogCode.LogCodeInfo._0003);
        return billing;
    }
}
