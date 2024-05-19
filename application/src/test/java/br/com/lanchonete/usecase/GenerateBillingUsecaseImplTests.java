package br.com.lanchonete.usecase;

import br.com.lanchonete.model.Billing;
import br.com.lanchonete.model.StatusPaymentType;
import br.com.lanchonete.port.repository.BillingRepository;
import br.com.lanchonete.port.repository.LogRepository;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenerateBillingUsecaseImplTests {

    @InjectMocks
    private GenerateBillingUsecase generateBillingUsecase;
    @Mock
    private BillingRepository billingRepository;
    @Mock
    private LogRepository logRepository;
    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests() {
        easyRandom = new EasyRandom();
    }

    @Test
    public void generateBilling() throws Exception {
        Billing billing = easyRandom.nextObject(Billing.class);
        billing.setStatus(StatusPaymentType.PENDING);
        when(billingRepository.save(billing)).thenReturn(billing);

        Billing billingOutput = generateBillingUsecase.generate(billing);

        assertThat(billingOutput).isNotNull();
        assertThat(billingOutput.getStatus()).isEqualTo(billing.getStatus());

    }

}
