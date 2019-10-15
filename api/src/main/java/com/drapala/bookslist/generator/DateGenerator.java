package com.drapala.bookslist.generator;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

@Component
public class DateGenerator {

    public static Supplier<Integer> createRandomDateSupplier(int from, int to) {
         Random random = new Random();
         return () -> random.nextInt((to - from) + 1) + 1960;
    }


}
