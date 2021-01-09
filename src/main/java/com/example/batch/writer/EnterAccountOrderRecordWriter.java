package com.example.batch.writer;

import com.alibaba.fastjson.JSON;
import com.example.batch.model.EnterAccountOrderRecord;
import com.example.batch.model.EnterAccountResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入账记录写
 *
 * @author 阿伟
 * @date 2021/1/9 16:40
 */
@Slf4j
@Service
public class EnterAccountOrderRecordWriter implements ItemWriter<EnterAccountResult> {


    /**
     * 入账记录更新
     *
     * @param list
     * @throws Exception
     */
    @Override
    public void write(List<? extends EnterAccountResult> list) throws Exception {
        log.info("writer:{}", JSON.toJSONString(list));
    }

}
