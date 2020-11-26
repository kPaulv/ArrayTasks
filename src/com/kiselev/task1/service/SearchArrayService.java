package com.kiselev.task1.service;

import com.kiselev.task1.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.StringTokenizer;

public class SearchArrayService {
    private static final Logger logger = LogManager.getLogger(SearchArrayService.class.getName());

    public int binarySearch(Array array, int number) {
        int[] arr = array.getArray();
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == number) {
                logger.info("Number found.");
                return middle;
            } else if (arr[middle] < number) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        logger.error("Number not found.");
        return -1;
    }

    public int max(Array array) {
        int[] arr = array.getArray();
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int min(Array array) {
        int[] arr = array.getArray();
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public int[] findPrimeNumbers(Array array) {
        int[] arr = array.getArray();
        int[] primeArray = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                primeArray[j] = arr[i];
                j++;
            }
        }

        if (j < primeArray.length) {
            int[] temp = new int[j];
            if (j >= 0) System.arraycopy(primeArray, 0, temp, 0, j);
            primeArray = new int[j];
            if (j >= 0) System.arraycopy(temp, 0, primeArray, 0, j);
        }

        return primeArray;
    }

    private boolean isPrime(int number) {
        if (number < 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] findThreeDigitNumbers(Array array) {
        int[] tempArray = new int[array.getSize()];
        int j = 0;
        for(int i = 0; i < array.getSize(); i++) {
            if((array.get(i) / 100 > 0 && array.get(i) / 1000 == 0) && !hasRepeated(array.get(i))) {
                tempArray[j] = array.get(i);
                j++;
            }
        }
        int[] threeDigit = new int[j];
        return threeDigit;
    }

    private boolean hasRepeated(int number) {
        int digit1 = number % 10;
        int digit2 = (number / 10) % 10;
        int digit3 = (number / 100) % 10;
        if(digit1 == digit2 || digit1 == digit3 || digit2 == digit3) {
            return true;
        }
        return false;
    }
}
