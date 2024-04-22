package br.com.lanchonete.mongo.repository;

import br.com.lanchonete.mongo.entity.BillingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataMongoBillingRepository extends MongoRepository<BillingEntity, String> {

    Optional<BillingEntity> findByOrderId(UUID orderId);

}
