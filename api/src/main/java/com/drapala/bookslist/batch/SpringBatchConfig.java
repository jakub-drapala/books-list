package com.drapala.bookslist.batch;

import com.drapala.bookslist.model.Book;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class SpringBatchConfig {

    /*@Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;*/

    @Value("input/books.txt")
    private String inputBooks;

    @Bean
    public ItemReader<Book> itemReader() {
        FlatFileItemReader<Book> fileReader = new FlatFileItemReader<>();
        fileReader.setResource(new ClassPathResource(inputBooks));

        LineMapper<Book> bookLineMapper = createBookLineMapper();
        fileReader.setLineMapper(bookLineMapper);
        return fileReader;
    }

    private LineMapper<Book> createBookLineMapper() {
        DefaultLineMapper<Book> bookLineMapper = new DefaultLineMapper<>();

        LineTokenizer bookLineTokenizer = createBookLineTokenizer();
        bookLineMapper.setLineTokenizer(bookLineTokenizer);

        FieldSetMapper<Book> bookInformationMapper = createBookInformationMapper();
        bookLineMapper.setFieldSetMapper(bookInformationMapper);

        return bookLineMapper;
    }

    private LineTokenizer createBookLineTokenizer() {
        DelimitedLineTokenizer bookLineTokenizer = new DelimitedLineTokenizer();
        bookLineTokenizer.setDelimiter("-");
        bookLineTokenizer.setNames(new String[] {"name", "author"});
        return bookLineTokenizer;
    }

    private FieldSetMapper<Book> createBookInformationMapper() {
        BeanWrapperFieldSetMapper<Book> bookInformationMapper = new BeanWrapperFieldSetMapper<>();
        bookInformationMapper.setTargetType(Book.class);
        return bookInformationMapper;
    }
}
