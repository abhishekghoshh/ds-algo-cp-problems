package com.util;

public class PrintUtl {
    public static void printException(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
