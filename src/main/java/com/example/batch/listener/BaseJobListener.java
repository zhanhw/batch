package com.example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Service;

/**
 * 基础job监听
 *
 * @author aw
 * @date 2021/1/8 16:16
 */
@Slf4j
@Service
public class BaseJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("-----------beforeJob---------------");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("-----------afterJob---------------");
    }
}
