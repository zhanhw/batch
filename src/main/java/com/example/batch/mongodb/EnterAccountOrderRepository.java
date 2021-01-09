package com.example.batch.mongodb;

import com.example.batch.model.EnterAccountOrderRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 订单入账
 *
 * @author zhw
 * @date 2020/8/12 17:28
 */
public interface EnterAccountOrderRepository extends MongoRepository<EnterAccountOrderRecord, String>, EnterAccountOrderRepositoryAdvance {
}
