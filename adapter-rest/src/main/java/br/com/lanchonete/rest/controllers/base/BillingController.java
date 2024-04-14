package br.com.lanchonete.rest.controllers.base;

import br.com.lanchonete.model.Billing;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.rest.controllers.base.dto.RequestBillingDTO;
import br.com.lanchonete.rest.exception.APIException;
import br.com.lanchonete.usecase.GenerateBillingUsecase;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import static br.com.lanchonete.rest.controllers.base.BillingController.BASE_PATH;

@Tag(name = "Endpoint Billing Provider")
@Validated
@RestController
@RequestMapping(path = BASE_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class BillingController {

    public static final String BASE_PATH = "/v1/billing";
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private GenerateBillingUsecase generateBillingUsecase;

    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Atualizada informações sobre a cobrança do pedido com sucesso") })
    @Operation(summary = "Persiste os dados de cobrança do pedido")
    @Counted(value = "execution.count.saveBilling")
    @Timed(value = "execution.time.saveBilling", longTask = true)
    @PostMapping
    public void saveBilling(@RequestBody @Valid RequestBillingDTO requestBillingDTO) throws APIException {
        try {
            generateBillingUsecase.generate(modelMapper.map(requestBillingDTO, Billing.class));
        } catch (Exception e) {
            throw APIException.internalError("Erro interno", Collections.singletonList(e.getMessage()));
        }
    }
}
