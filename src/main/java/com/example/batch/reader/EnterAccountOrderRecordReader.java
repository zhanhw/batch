package com.example.batch.reader;

import com.example.batch.model.EnterAccountOrderRecord;
import com.example.batch.mongodb.EnterAccountOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

/**
 * 读方法
 *
 * @author 阿伟
 * @date 2021/1/9 14:15
 */
@Slf4j
@Service
public class EnterAccountOrderRecordReader implements ItemReader<EnterAccountOrderRecord> {

    private Iterator<EnterAccountOrderRecord> dataItemIterator;

    @Autowired
    private EnterAccountOrderRepository enterAccountOrderRepository;

    /**
     * 读取入账记录
     *
     * @return
     */
    @Override
    public EnterAccountOrderRecord read() {
        List<EnterAccountOrderRecord> enterAccountOrderRecord = enterAccountOrderRepository.findByCustId("MBHMJ");
        if (CollectionUtils.isEmpty(enterAccountOrderRecord)) {
            return null;
        }
        return enterAccountOrderRecord.iterator().next();
    }
}
