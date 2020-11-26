package com.kiselev.task1.report;

import com.kiselev.task1.entity.Array;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReport {
    private static final Logger logReport = LogManager.getLogger(ArrayReport.class.getName());

    public void showArray(int[] arr) {
        Array array = new Array(arr);
        logReport.info("Array: " + array.toString());
    }

    public void showNumber(int searchNum, int index) {
        if(index == -1) {
            logReport.log(Level.valueOf("ERROR"), "Number " + searchNum + "not found.");
        } else {
            logReport.info("Number" + searchNum + " found. Index - " + index);
        }
    }

    public void showMin(int min) {
        logReport.info("Min: " + min);
    }

    public void showMax(int max) {
        logReport.info("Max: " + max);
    }

    public void showPrimeArray(Array arrayPrime) {
        if(arrayPrime.getSize() == 0) {
            logReport.log(Level.valueOf("ERROR"), "No prime numbers in the array.");
        } else {
            logReport.info("Prime numbers from the array: " + arrayPrime.toString());
        }
    }

    public void showFibonacciArray(Array fibonacci) {
        if(fibonacci.getSize() == 0) {
            logReport.log(Level.valueOf("ERROR"), "No prime numbers in the array.");
        } else {
            logReport.info("Fibonacci numbers from the array: " + fibonacci.toString());
        }
    }

    public void showThreeDigitArray(Array threeDigit) {
        if(threeDigit.getSize() == 0) {
            logReport.log(Level.valueOf("ERROR"), "No prime numbers in the array.");
        } else {
            logReport.info("Three digit numbers from the array: " + threeDigit.toString());
        }
    }
}
