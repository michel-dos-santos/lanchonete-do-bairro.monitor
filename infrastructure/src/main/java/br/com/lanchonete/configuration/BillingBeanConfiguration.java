package br.com.lanchonete.configuration;

import br.com.lanchonete.port.repository.BillingRepository;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.NotifyOrderRepository;
import br.com.lanchonete.usecase.GenerateBillingUsecase;
import br.com.lanchonete.usecase.UpdateBillingByHubUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillingBeanConfiguration {

    @Bean
    GenerateBillingUsecase generateBilling(LogRepository logRepository, BillingRepository billingRepository) {
        return new GenerateBillingUsecase(logRepository, billingRepository);
    }

    @Bean
    UpdateBillingByHubUsecase updateBillingByHub(LogRepository logRepository, BillingRepository billingRepository, NotifyOrderRepository notifyOrderRepository) {
        return new UpdateBillingByHubUsecase(logRepository, billingRepository, notifyOrderRepository);
    }

}
