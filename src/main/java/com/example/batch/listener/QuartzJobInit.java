package com.example.batch.listener;

import com.example.batch.utils.QuartzUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author 阿伟
 * @date 2021/1/9 18:21
 */
@Component
public class QuartzJobInit implements CommandLineRunner {

    @Autowired
    private QuartzUtils quartzUtils;

    @Override
    public void run(String... args) throws Exception {
        quartzUtils.addSingleJob(EnterAccountQuartzJob.class, "enterAccountJob", 60);
    }

}
