package com.example.batch.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 消息策略注解
 *
 * @author aw
 * @date 2021/1/13 15:20
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MessageStrategy {

    /**
     * 执行策略key
     *
     * @return
     */
    String key() default "";

}
