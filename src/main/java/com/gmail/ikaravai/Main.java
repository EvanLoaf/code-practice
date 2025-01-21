package com.gmail.ikaravai;

import com.gmail.ikaravai.problems.LettersCounter;
import com.gmail.ikaravai.util.CustomLogFormatter;

import java.util.Objects;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Java shenanigans");

    public static void main(String[] args) {
        setLogFormat();

        lettersCounter();
    }

    private static void lettersCounter() {
        var lettersCounter = new LettersCounter();
        var result = lettersCounter.countLetters("My very random string of characters of DiFFerent CaSEs");
        if (Objects.nonNull(result))
            logger.info(result::toString);
    }

    private static void setLogFormat() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.getHandlers()[0].setFormatter(new CustomLogFormatter());
    }
}
