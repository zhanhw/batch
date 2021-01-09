package com.example.batch.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

/**
 * 基础校验
 *
 * @author aw
 * @date 2021/1/8 16:14
 */
@Slf4j
public class BaseItemValidator<T> implements Validator<T>, InitializingBean {
    @Override
    public void validate(T t) throws ValidationException {
        log.info("-----------validate--------------- : {}", t.toString());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-----------afterPropertiesSet---------------");
    }
}
