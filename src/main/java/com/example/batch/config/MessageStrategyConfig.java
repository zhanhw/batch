package com.example.batch.config;

import com.alibaba.fastjson.JSON;
import com.example.batch.annotation.MessageStrategy;
import com.example.batch.model.MessageStrategyInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扫描注解信息
 *
 * @author aw
 * @date 2021/1/13 15:35
 */
@Slf4j
@Configuration
public class MessageStrategyConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Map<String, MessageStrategyInfo> beansWithAnnotationMap() {
        Map<String, MessageStrategyInfo> beansWithAnnotationMap = new ConcurrentHashMap<>();
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(MessageStrategy.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object value = entry.getValue();
            Class<?> allClass = AopUtils.getTargetClass(value);
            //类上的所有方法
            List<Method> methods = Arrays.asList(allClass.getMethods());
            if (!CollectionUtils.isEmpty(methods)) {
                methods.stream().filter(method ->
                        method.isAnnotationPresent(MessageStrategy.class)).forEach(method -> {
                    MessageStrategy annotation = method.getAnnotation(MessageStrategy.class);
                    beansWithAnnotationMap.put(annotation.key(), MessageStrategyInfo.builder()
                            .classname(method.getAnnotatedReceiverType().getType().getTypeName())
                            .methodName(method.getName())
                            .parameterTypes(method.getParameterTypes())
                            .build());
                });
            }
        }
        log.info("messageStrategyMap:{}", JSON.toJSONString(beansWithAnnotationMap));
        return beansWithAnnotationMap;
    }
}
