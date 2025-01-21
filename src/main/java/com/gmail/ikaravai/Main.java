package com.gmail.ikaravai;

import com.gmail.ikaravai.problems.LettersCounter;

import java.util.Objects;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Java shenanigans");

    public static void main(String[] args) {
        lettersCounter();
    }

    private static void lettersCounter() {
        logger.info(getCurrentMethodName());
        var lettersCounter = new LettersCounter();
        var result = lettersCounter.countLetters("My very random string of characters of DiFFerent CaSEs");
        if (Objects.nonNull(result))
            logger.info(result::toString);
    }

    public static String getCurrentMethodName()
    {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 2].getMethodName();
    }

}
