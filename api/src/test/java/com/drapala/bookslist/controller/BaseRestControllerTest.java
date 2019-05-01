package com.drapala.bookslist.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.drapala.bookslist.TestSetup;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@EnableSpringDataWebSupport
public abstract class BaseRestControllerTest implements TestSetup {

    @Autowired
    private ObjectMapper jsonMapper;

    @Autowired
    protected MockMvc api;

    protected String json(Object object) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(object);
    }


}
