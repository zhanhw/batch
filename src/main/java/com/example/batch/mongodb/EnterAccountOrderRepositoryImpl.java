package com.example.batch.mongodb;

import com.example.batch.model.EnterAccountOrderRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 入账记录
 *
 * @author 阿伟
 * @date 2021/1/9 17:58
 */
public class EnterAccountOrderRepositoryImpl implements EnterAccountOrderRepositoryAdvance {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<EnterAccountOrderRecord> findByCustId(String custId) {
        return mongoTemplate.find(Query.query(Criteria.where("custId").is(custId)), EnterAccountOrderRecord.class);
    }
}
