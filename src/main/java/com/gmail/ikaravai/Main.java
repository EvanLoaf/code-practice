package com.gmail.ikaravai;

import com.gmail.ikaravai.problems.Fibonacci;
import com.gmail.ikaravai.problems.LettersCounter;
import com.gmail.ikaravai.util.CustomLogFormatter;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Java shenanigans");

    public static void main(String[] args) {
        setLogFormat();

//        lettersCounter();
        fibonacci();
    }

    private static void lettersCounter() {
        var lettersCounter = new LettersCounter();
        var result = lettersCounter.countLetters("My very random string of characters of DiFFerent CaSEs");
        logger.info(result::toString);
    }

    private static void fibonacci() {
        var fibonacci = new Fibonacci();
        int recursiveInput = 10;
        int memorizationInput = 11;
        var recursiveResult = fibonacci.calculateRecursive(recursiveInput);
        var memorizationResult = fibonacci.calculateWithMemory(memorizationInput);
        logger.info(() -> STR."recursive N\{recursiveInput}: \{recursiveResult}, memorization N\{memorizationInput}: \{memorizationResult}");
    }

    private static void setLogFormat() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.getHandlers()[0].setFormatter(new CustomLogFormatter());
    }
}
