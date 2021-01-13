package com.example.batch.strategy;

import com.example.batch.annotation.MessageStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 基础测试
 *
 * @author aw
 * @date 2021/1/13 15:42
 */
@Slf4j
@MessageStrategy
@Service
public class BaseMessageStrategy {

    @MessageStrategy(key = "default")
    public void execute(String body) {
        log.info("-------------执行了--------------- {}", body);
    }

}
