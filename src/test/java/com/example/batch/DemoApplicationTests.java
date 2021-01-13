package com.example.batch;

import com.example.batch.strategy.MessageStrategyCommonManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private MessageStrategyCommonManager messageStrategyCommonManager;

    @Test
    void contextLoads() throws Exception {
        messageStrategyCommonManager.consume("default", "参数信息");
    }

}
