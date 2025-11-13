package org.example;

import java.util.logging.Logger;

public class CodeAnalysis {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(CodeAnalysis.class.getName());

        log.info("Enter first number:");
        int num1 = 6;
        log.info("Enter second number:");
        int num2 = 2;

        int sum = sumOfValues(num1, num2);
        int sub = subOfValues(num1, num2);
        int div = divOfValues(num1, num2);
        int mul = mulOfValues(num1, num2);

        log.info((() -> String.format("The sum is: [%s]", sum)));
        log.info((() -> String.format("The sub is: [%s]", sub)));
        log.info((() -> String.format("The div is: [%s]", div)));
        log.info((() -> String.format("The mul is: [%s]", mul)));
    }

    public static int sumOfValues(int num1, int num2) {
        return num1 + num2;
    }

    public static int subOfValues(int num1, int num2) {
        return num1 - num2;
    }

    public static int divOfValues(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }

        return num1 / num2;
    }

    public static int mulOfValues(int num1, int num2) {
        return num1 * num2;
    }
}