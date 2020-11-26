package com.kiselev.task1.service;

import com.kiselev.task1.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortArrayService {
    private static final Logger logger = LogManager.getLogger(SortArrayService.class.getName());
    public int[] bubbleSort(Array array) {
        int[] arr = array.getArray();
        int bound = arr.length - 1;
        boolean swapped;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < bound; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            bound--;
        }
        logger.info("Array sorted with bubble sort.");
        return arr;
    }

    public int[] insertionSort(Array array) {
        int[] arr = array.getArray();
        int j;
        int temp;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            while (j > 0 && (arr[j - 1] > arr[j])) {
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        logger.info("Array sorted with insertion sort.");
        return arr;
    }

    public int[] selectionSort(Array array) {
        int[] arr = array.getArray();

        int minIndex;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        logger.info("Array sorted with selection sort.");
        return arr;
    }
}
