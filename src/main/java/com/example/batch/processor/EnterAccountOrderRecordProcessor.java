package com.example.batch.processor;

import com.example.batch.model.EnterAccountOrderRecord;
import com.example.batch.model.EnterAccountResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.stereotype.Service;

/**
 * 入账记录处理
 *
 * @author 阿伟
 * @date 2021/1/9 16:38
 */
@Slf4j
@Service
public class EnterAccountOrderRecordProcessor implements ItemProcessor<EnterAccountOrderRecord, EnterAccountResult> {

    /**
     * 入账
     *
     * @param item
     * @return
     * @throws ValidationException
     */
    @Override
    public EnterAccountResult process(EnterAccountOrderRecord item) throws ValidationException {
        log.info("process:{}", item.toString());
        return EnterAccountResult.builder().billNo("123").status(1).orderId(item.getOrderId()).build();
    }
}
