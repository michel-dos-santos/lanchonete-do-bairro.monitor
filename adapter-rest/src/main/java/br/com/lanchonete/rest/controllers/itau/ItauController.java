package br.com.lanchonete.rest.controllers.itau;

import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.rest.controllers.base.ConsumerControllerBase;
import br.com.lanchonete.rest.controllers.itau.dto.ItauRequestDTO;
import br.com.lanchonete.rest.exception.APIException;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Endpoint Billing Provider Itaú")
@Validated
@RestController
@RequestMapping(path = ConsumerControllerBase.BASE_PATH+ItauController.BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class ItauController extends ConsumerControllerBase {

    public static final String BASE_PATH = "/itau";

    @Autowired
    private LogRepository logRepository;

    @Counted(value = "execution.count.updateBillingByItau")
    @Timed(value = "execution.time.updateBillingByItau", longTask = true)
    @PutMapping
    public void updateBillingByItau(@RequestBody @Valid ItauRequestDTO itauRequestDTO) throws APIException {
        logRepository.info(ItauController.class, LogCode.LogCodeInfo._0006);

        updateBillingBy(itauRequestDTO.getStatusPaymentType(), itauRequestDTO.getOrderId());
    }
}
