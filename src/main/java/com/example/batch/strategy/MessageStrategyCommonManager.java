package com.example.batch.strategy;

import com.example.batch.model.MessageStrategyInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通用执行
 *
 * @author aw
 * @date 2021/1/13 17:35
 */
@Slf4j
@Service
public class MessageStrategyCommonManager {

    @Autowired
    private final Map<String, MessageStrategyInfo> messageStrategyMap = new ConcurrentHashMap<>();

    /**
     * 通用消费
     *
     * @param key
     * @throws Exception
     */
    public void consume(String key, String body) throws Exception {
        MessageStrategyInfo messageStrategyInfo = messageStrategyMap.get(key);
        //得到类字节码对象-加载该类进内存
        Class<?> aClass = Class.forName(messageStrategyInfo.getClassname());
        //得到对象
        Object o = aClass.newInstance();
        //调用方法
        Method declaredMethod = aClass.getDeclaredMethod(messageStrategyInfo.getMethodName(), messageStrategyInfo.getParameterTypes());
        declaredMethod.invoke(o, body);
    }

}
