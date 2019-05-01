package com.drapala.bookslist;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles
public interface TestSetup {

    void init();

    void afterTest();
}
