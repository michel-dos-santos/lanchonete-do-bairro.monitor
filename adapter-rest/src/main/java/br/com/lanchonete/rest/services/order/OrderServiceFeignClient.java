package br.com.lanchonete.rest.services.order;

import br.com.lanchonete.model.StatusPaymentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.UUID;

@FeignClient(value = "orderServiceFeignClient", url = "${api.order.url}", fallbackFactory = OrderServiceFallback.class)
public interface OrderServiceFeignClient {

    @PutMapping(value = "/{orderId}/status-payment/{status}")
    void billing(@PathVariable UUID orderId, @PathVariable StatusPaymentType status);

}
