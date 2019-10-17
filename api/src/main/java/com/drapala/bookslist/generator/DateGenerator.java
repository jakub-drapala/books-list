package com.drapala.bookslist.generator;

import com.drapala.bookslist.enums.Cover;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DateGenerator {

    private static final int FROM = 1960;

    private static final int TO = 2019;

    private static Random random = new Random();

    public static int getRandomDate() {
        return random.nextInt((TO - FROM) + 1) + FROM;
    }

    public static Cover getRandomCover() {
        int r = random.nextInt(2);
        switch (r) {
            case 0:
                return Cover.LIMP_BINDING;
            case 1:
                return Cover.HARDCOVER;
            default:
                return null;

        }
    }

}
