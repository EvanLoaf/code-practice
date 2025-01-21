package com.gmail.ikaravai.util;

import java.lang.reflect.Method;

public class ExecutionTimer {

    private ExecutionTimer() {}

    public static Object invokeWithTimer(Object obj, String methodName, Class<?>[] paramTypes, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, paramTypes);
            long start = System.nanoTime();
            Object result = method.invoke(obj, args);
            long end = System.nanoTime();
            double durationInSeconds = (end - start) / 1_000_000_000.0;  // Convert to seconds
            System.out.printf("Execution time for method %s: %.3f sec%n", methodName, durationInSeconds);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
