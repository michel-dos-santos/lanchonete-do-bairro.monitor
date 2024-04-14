package br.com.lanchonete.rest.services.order;

import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.model.StatusPaymentType;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.NotifyOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class NotifyOrder implements NotifyOrderRepository {

    @Autowired
    private OrderServiceFeignClient serviceFeignClient;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LogRepository logRepository;

    public void sendNotification(StatusPaymentType statusPaymentType, UUID billingOrderId) {
        logRepository.info(NotifyOrder.class, LogCode.LogCodeInfo._0032);
        serviceFeignClient.billing(billingOrderId, statusPaymentType);
        logRepository.info(NotifyOrder.class, LogCode.LogCodeInfo._0033);
    }

}