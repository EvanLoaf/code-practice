package com.gmail.ikaravai;

import com.gmail.ikaravai.problems.Fibonacci;
import com.gmail.ikaravai.problems.HanoiTower;
import com.gmail.ikaravai.problems.LettersCounter;
import com.gmail.ikaravai.problems.StringPermutation;
import com.gmail.ikaravai.util.CustomLogFormatter;
import com.gmail.ikaravai.util.ExecutionTimer;

import java.util.Stack;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger("Java shenanigans");

    public static void main(String[] args) {
        setLogFormat();

//        lettersCounter();
//        fibonacci();
//        hanoiTower();
        stringPermutation();
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

    private static void hanoiTower() {
        int numberOfDisks = 10; // tower height
        boolean muteOperations = true; // controls output of specific moves

        var fromRod = new Stack<Integer>();
        var auxiliaryRod = new Stack<Integer>();
        var toRod = new Stack<Integer>();

        // Populate the first rod
        for (int i = numberOfDisks; i >= 1; i--) {
            fromRod.push(i);
        }

        // initial state
        logger.info(() -> fromRod + System.lineSeparator() + auxiliaryRod + System.lineSeparator() + toRod + System.lineSeparator());

        var hanoiTower = new HanoiTower(fromRod, toRod, auxiliaryRod, muteOperations);
        hanoiTower.solve(fromRod.size(), fromRod, toRod, auxiliaryRod);

        // result state
        logger.info(() -> fromRod + System.lineSeparator() + auxiliaryRod + System.lineSeparator() + toRod + System.lineSeparator());
    }

    private static void stringPermutation() {
        var stringPermutation = new StringPermutation();
        var input = "input123";
        Class<?>[] paramTypes = { String.class, String.class };
        ExecutionTimer.invokeWithTimer(stringPermutation, "permute", paramTypes, input, "");
    }

    private static void setLogFormat() {
        Logger rootLogger = Logger.getLogger("");
        rootLogger.getHandlers()[0].setFormatter(new CustomLogFormatter());
    }
}
