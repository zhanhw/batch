package com.example.batch.processor;

import com.example.batch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

/**
 * 处理器
 *
 * @author aw
 * @date 2021/1/8 16:11
 */
@Slf4j
public class BaseItemProcessor extends ValidatingItemProcessor<Person> {

    @Override
    public Person process(Person item) throws ValidationException {
        log.info("-----------process--------------- {}", item.toString());
        if (18 == item.getAge()) {
            item.setAddress("上海");
        }
        if (20 == item.getAge()) {
            item.setAddress("北京");
        }
        return super.process(item);
    }
}
