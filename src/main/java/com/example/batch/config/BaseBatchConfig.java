package com.example.batch.config;

import com.example.batch.listener.BaseJobListener;
import com.example.batch.model.Person;
import com.example.batch.processor.BaseItemProcessor;
import com.example.batch.validator.BaseItemValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

/**
 * 基础批量配置
 *
 * @author aw
 * @date 2021/1/8 16:07
 */
//@Configuration
//@EnableBatchProcessing
public class BaseBatchConfig {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private StepBuilderFactory sf;
    @Autowired
    private JobBuilderFactory jf;

    @Bean
    public ItemReader<Person> reader() throws Exception {
        return new IteratorItemReader<>(Arrays.asList(Person.builder().name("tom").age(18).build(),
                Person.builder().name("bob").age(20).build()));
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        BaseItemProcessor processor = new BaseItemProcessor();
        processor.setValidator(baseItemValidator());
        return processor;
    }

    @Bean
    public ItemWriter<Person> writer() {
        MongoItemWriter<Person> writer = new MongoItemWriter<>();
        writer.setTemplate(mongoTemplate);
        writer.setCollection("person");
        return writer;
    }

    /**
     * 流程
     * reader => BaseItemValidator(afterPropertiesSet) => BaseJobLauncher(run) => BaseJobListener(beforeJob) =>
     * BaseItemProcessor(process) => BaseItemValidator(validate) => writer => BaseJobListener(afterJob)
     *
     * @return
     * @throws Exception
     */
    @Bean
    public Step stepA() throws Exception {
        return sf.get("stepA")
                .<Person, Person>chunk(3)
                .reader(reader())
                .processor(processor())
                .writer(writer()).build();
    }

    @Bean
    public Job jobA() throws Exception {
        return jf.get("jobA")
                .incrementer(new RunIdIncrementer())
                .listener(baseJobListener())
                .start(stepA())
                .build();
    }

    @Bean
    public BaseJobListener baseJobListener() {
        return new BaseJobListener();
    }

    @Bean
    public Validator<Person> baseItemValidator() {
        return new BaseItemValidator<>();
    }

}
