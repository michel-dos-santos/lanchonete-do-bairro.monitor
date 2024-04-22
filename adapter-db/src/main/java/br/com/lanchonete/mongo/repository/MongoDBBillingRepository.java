package br.com.lanchonete.mongo.repository;

import br.com.lanchonete.exception.billing.BillingNotFoundException;
import br.com.lanchonete.model.Billing;
import br.com.lanchonete.model.StatusPaymentType;
import br.com.lanchonete.mongo.entity.BillingEntity;
import br.com.lanchonete.port.repository.BillingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDBBillingRepository implements BillingRepository {

    private final SpringDataMongoBillingRepository billingRepository;
    private final ModelMapper modelMapper;

    public MongoDBBillingRepository(SpringDataMongoBillingRepository billingRepository, ModelMapper modelMapper) {
        this.billingRepository = billingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public Billing save(Billing billing) {
        BillingEntity billingEntity = modelMapper.map(billing, BillingEntity.class);
        return modelMapper.map(billingRepository.save(billingEntity), Billing.class);
    }

    @Override
    public Billing updateStatusPaymentType(UUID orderId, StatusPaymentType status) {
        Billing billing = findByOrderId(orderId);
        billing.setStatus(status);
        return save(billing);
    }

    @Override
    @Transactional
    public Billing findByOrderId(UUID orderId) {
        Optional<BillingEntity> billingEntityOptional = billingRepository.findByOrderId(orderId);
        if (billingEntityOptional.isEmpty()) {
            throw new BillingNotFoundException("orderId", null, orderId.toString(), null);
        }
        return modelMapper.map(billingEntityOptional.get(), Billing.class);
    }

}
