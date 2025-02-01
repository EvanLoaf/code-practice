package com.gmail.ikaravai;

import com.gmail.ikaravai.problems.Fibonacci;
import com.gmail.ikaravai.problems.HanoiTower;
import com.gmail.ikaravai.problems.LettersCounter;
import com.gmail.ikaravai.problems.StringPermutation;
import com.gmail.ikaravai.sort.BubbleSort;
import com.gmail.ikaravai.sort.InsertionSort;
import com.gmail.ikaravai.sort.QuickSort;
import com.gmail.ikaravai.util.CustomLogFormatter;
import com.gmail.ikaravai.util.ExecutionTimer;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static final Logger logger = Logger.getLogger("Java shenanigans");

    public static void main(String[] args) {
        setLogFormat();

//        sandbox();


//        lettersCounter();
//        fibonacci();
//        hanoiTower();
//        stringPermutation();
//        bubbleSort();
//        quickSort();
        insertionSort();
    }

    private static void insertionSort() {
        var insertionSort = new InsertionSort();
        var input = prepareSortingInput();
        logger.info(STR."Input: \{input}");
        var inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        var result = insertionSort.sort(inputArray);
        logger.info(STR."Result: \{Arrays.toString(result)}");
    }

    private static void quickSort() {
        var quickSort = new QuickSort();
        var input = prepareSortingInput();
        logger.info(STR."Input: \{input}");
        var inputArray = input.stream().mapToInt(Integer::intValue).toArray();
        var result = quickSort.sort(inputArray, 0, inputArray.length - 1);
        logger.info(STR."Result: \{Arrays.toString(result)}");
    }

    private static void bubbleSort() {
        var bubbleSort = new BubbleSort();
        var input = prepareSortingInput();
        logger.info(STR."Input: \{input}");
        var result = bubbleSort.sort(input.stream().mapToInt(Integer::intValue).toArray());
        logger.info(STR."Result: \{Arrays.toString(result)}");
    }

    private static List<Integer> prepareSortingInput() {
        List<Integer> input = new ArrayList<>(IntStream.range(0, 100).boxed().toList());
        Collections.shuffle(input);
        return input;
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

    private static void sandbox() {
        //        try {
//            main(args);
//        } catch (StackOverflowError e) {
//            main(args);
//        }

//        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(Arrays.deepToString(arr));

//        List<String> list = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        Map<String, Integer> mapa = new HashMap<>();
//        Object asd = new Object();
//
//        int[] numbs1 = new int[]{1,2,3};
//        System.out.println(Arrays.hashCode(numbs1));
//
//        int[] numbs2 = new int[]{1,2,3};
//        System.out.println(Arrays.hashCode(numbs2));

//        A obj = new B();
//        obj.a();
//
//        var t = Thread.ofVirtual().unstarted(() -> System.out.println("Test"));
//        new Thread(() -> {});
//
//        Map<String, String> map = new ConcurrentHashMap<>();
//        var asd = new AtomicInteger(7);
//        var qwe = new ThreadLocal<String>();
//        new ReentrantLock();
//        ExecutorService exec = Executors.newFixedThreadPool(3);
//        var sss = new CompletableFuture<String>();
////        sss.completeAsync();
////        var tt = new ForkJoinTask<String>();
//        var ll = new LinkedList<String>();
//        var it = ll.listIterator();
//        List<String> stack = new Stack<>();
    }

    //    static class A {
//        public void a() {
//            System.out.println("parent");
//        }
//    }
//
//    static class B extends A {
//        @Override
//        public void a() {
//            System.out.println("child");
//        }
//    }
}
