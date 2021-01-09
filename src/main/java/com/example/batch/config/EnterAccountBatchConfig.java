package com.example.batch.config;

import com.example.batch.listener.BaseJobListener;
import com.example.batch.model.EnterAccountOrderRecord;
import com.example.batch.model.EnterAccountResult;
import com.example.batch.processor.EnterAccountOrderRecordProcessor;
import com.example.batch.reader.EnterAccountOrderRecordReader;
import com.example.batch.writer.EnterAccountOrderRecordWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.batch.api.listener.JobListener;


/**
 * 批量入账
 *
 * @author aw
 * @date 2021/1/8 16:07
 */
@Configuration
@EnableBatchProcessing
public class EnterAccountBatchConfig {

    @Autowired
    private EnterAccountOrderRecordReader enterAccountOrderRecordReader;
    @Autowired
    private EnterAccountOrderRecordProcessor enterAccountOrderRecordProcessor;
    @Autowired
    private EnterAccountOrderRecordWriter enterAccountOrderRecordWriter;
    @Autowired
    private StepBuilderFactory sf;
    @Autowired
    private JobBuilderFactory jf;
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public BaseJobListener baseJobListener;

    @Bean
    public Step enterAccountStep() {
        return sf.get("enterAccountStep")
                .<EnterAccountOrderRecord, EnterAccountResult>chunk(1)
                .reader(enterAccountOrderRecordReader)
                .processor(enterAccountOrderRecordProcessor)
                .writer(enterAccountOrderRecordWriter).build();
    }

    @Bean
    public Job enterAccountJob() {
        return jf.get("enterAccountJob")
                .incrementer(new RunIdIncrementer())
                .start(enterAccountStep())
                .build();
    }

    @Bean(name = "enterAccountJob")
    public Job batchJob() {
        return jobBuilderFactory.get("enterAccountJob")
                .listener(baseJobListener)
                .incrementer(new RunIdIncrementer())
                .flow(enterAccountStep())
                .end()
                .build();
    }

}
