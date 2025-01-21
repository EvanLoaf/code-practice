package com.gmail.ikaravai.problems;

import java.util.Stack;

public class HanoiTower {

    private final Stack<Integer> fromStack;
    private final Stack<Integer> toStack;
    private final Stack<Integer> auxiliaryStack;
    private final boolean mute;

    public HanoiTower(Stack<Integer> fromStack, Stack<Integer> toStack, Stack<Integer> auxiliaryStack, boolean mute) {
        this.fromStack = fromStack;
        this.toStack = toStack;
        this.auxiliaryStack = auxiliaryStack;
        this.mute = mute;
    }

    // recursively splitting and solving the problem
    public void solve(int n, Stack<Integer> fromStack, Stack<Integer> toStack, Stack<Integer> auxiliaryStack) {
        if (n == 1) {
            moveDisk(fromStack, toStack);
            return;
        }

        solve(n - 1, fromStack, auxiliaryStack, toStack);
        moveDisk(fromStack, toStack);
        solve(n - 1, auxiliaryStack, toStack, fromStack);
    }

    private void moveDisk(Stack<Integer> fromStack, Stack<Integer> toStack) {
        int disk = fromStack.pop();
        toStack.push(disk);
        if (!mute)
            System.out.println(STR."Moved disk \{disk} from rod \{getRodName(fromStack)} to rod \{getRodName(toStack)}");
    }

    private String getRodName(Stack<Integer> stack) {
        if (stack == this.fromStack) return "A";
        if (stack == this.auxiliaryStack) return "B";
        if (stack == this.toStack) return "C";
        return "Unknown";
    }
}
