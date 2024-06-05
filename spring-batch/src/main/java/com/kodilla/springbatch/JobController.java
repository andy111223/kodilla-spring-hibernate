package com.kodilla.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importUserJob;

    @Secured("ROLE_BASIC")
    @GetMapping("/start")
    public String startBatchJob() {
        try {
            jobLauncher.run(importUserJob, new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis()).toJobParameters());
            return "Batch job has been invoked";
        } catch (Exception e) {
            e.printStackTrace();
            return "Batch job failed: " + e.getMessage();
        }
    }
}
