package com.drapala.bookslist.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@StepScope
public class BookItemReader extends FlatFileItemReader<String> implements StepExecutionListener {

    private Resource resource;
    private InputStream is;
    private BufferedReader bufferedReader;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        try {
            this.is = resource.getInputStream();
        } catch (Exception e) {
        }
        bufferedReader = new BufferedReader(new InputStreamReader(this.is));

    }

    public BookItemReader() {
        setLineMapper((s, i) -> s.trim());
        setResource((new ClassPathResource("static/input/books.txt")));
        setStrict(true);
        this.resource = new ClassPathResource("static/input/books.txt");
    }

    @Override
    protected String doRead() throws Exception {
        //Resource resource = new ClassPathResource("static/input/books.txt");
        //InputStream io = resource.getInputStream();
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.is));
        String s = bufferedReader.readLine();

        return s;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
