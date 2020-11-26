package com.kiselev.task1.service;

import com.kiselev.task1.entity.Array;

public class FibonacciService {
    public int[] findFibonacciNumbers(Array array) {
        int[] tempArray = new int[array.getSize()];
        int j = 0;
        for(int i = 0; i < array.getSize(); i++) {
            if(isFibonacciNumber(array.get(i))) {
                tempArray[j] = array.get(i);
                j++;
            }
        }
        int[] fibonacci = new int[j];
        if(j > 0) {
            for (int i = 0; i < j; i++) {
                fibonacci[i] = tempArray[i];
            }
        }
        return fibonacci;
    }

    boolean isFibonacciNumber(int number) {
        if (number == 0) {
            return true;
        }
        int a = 0;
        int b = 1;
        int temp;
        while (number >= b) {
            temp = b;
            b += a;
            a = temp;
            if (number == b) {
                return true;
            }
        }
        return false;
    }
}
