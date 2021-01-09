package com.example.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 阿伟
 * @date 2021/1/9 18:19
 */
@Component
@Slf4j
@DisallowConcurrentExecution
public class EnterAccountQuartzJob extends QuartzJobBean {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobLocator jobLocator;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            Job job = jobLocator.getJob("enterAccountJob");
            jobLauncher.run(job, new JobParametersBuilder()
                    .addString("executedTime", "2021-01-09 18:27:00")
                    .toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("任务[enterAccountJob]启动失败，错误信息:{}", e.getMessage());
        }
    }
}
