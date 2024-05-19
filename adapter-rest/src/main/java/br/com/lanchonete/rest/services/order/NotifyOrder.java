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

    public void sendNotification(StatusPaymentType statusPaymentType, UUID orderId) {
        logRepository.info(NotifyOrder.class, LogCode.LogCodeInfo._0004);
        serviceFeignClient.billing(orderId, statusPaymentType);
        logRepository.info(NotifyOrder.class, LogCode.LogCodeInfo._0005);
    }

}