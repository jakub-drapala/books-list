package com.drapala.bookslist.service.impl;

import com.drapala.bookslist.service.BatchService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

@Service
public class BatchServiceImpl implements BatchService {

    private JobLauncher jobLauncher;
    private Job importBooksJob;

    public BatchServiceImpl(JobLauncher jobLauncher, Job importBooksJob) {
        this.jobLauncher = jobLauncher;
        this.importBooksJob = importBooksJob;
    }

    @Override
    public void runBatch() throws Exception {
        JobParametersBuilder builder = new JobParametersBuilder()
                .addString("param1", "value1");
        jobLauncher.run(importBooksJob, builder.toJobParameters());
    }
}
