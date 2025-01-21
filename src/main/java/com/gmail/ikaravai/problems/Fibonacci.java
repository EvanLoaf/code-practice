package com.gmail.ikaravai.problems;

public class Fibonacci {

    public int calculateRecursive(int n) {
        if (n <= 1) return n;
        return calculateRecursive(n - 1) + calculateRecursive(n - 2);
    }

    public int calculateWithMemory(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
