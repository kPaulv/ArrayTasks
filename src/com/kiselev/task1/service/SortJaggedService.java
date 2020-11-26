package com.kiselev.task1.service;

import com.kiselev.task1.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortJaggedService {
    private static final Logger logger = LogManager.getLogger(SortJaggedService.class.getName());

    public int[][] sumIncreaseSort(JaggedArray jagged) {
        int[][] tempArray = jagged.getJagged();
        int bound = tempArray.length - 1;
        boolean swapped;
        int[] temp;
        for (int i = 0; i < tempArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < bound; j++) {
                if (lineSum(tempArray[j]) > lineSum(tempArray[j + 1])) {
                    temp = copyArray(tempArray[j]);
                    tempArray[j] = copyArray(tempArray[j + 1]);
                    tempArray[j + 1] = copyArray(temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            bound--;
        }
        logger.info("Array sorted by sum increase with bubble sort.");
        return tempArray;
    }

    public int[][] sumDecreaseSort(JaggedArray jagged) {
        int[][] increaseArray = sumIncreaseSort(jagged);
        int[][] tempArray;
        tempArray = new int[increaseArray.length][];
        for(int i = 0; i < increaseArray.length; i++) {
            tempArray[i] = copyArray(increaseArray[increaseArray.length - 1 - i]);
        }
        logger.info("Array sorted by sum decrease with bubble sort.");
        return tempArray;
    }

    private int lineSum(int[] line) {
        int sum = 0;
        for(int i = 0; i < line.length; i++) {
            sum += line[i];
        }
        return sum;
    }

    public int[][] maxIncreaseSort(JaggedArray jagged) {
        int[][] tempArray = jagged.getJagged();
        int bound = tempArray.length - 1;
        boolean swapped;
        int[] temp;
        for (int i = 0; i < tempArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < bound; j++) {
                if (lineMax(tempArray[j]) > lineMax(tempArray[j + 1])) {
                    temp = copyArray(tempArray[j]);
                    tempArray[j] = copyArray(tempArray[j + 1]);
                    tempArray[j + 1] = copyArray(temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            bound--;
        }
        logger.info("Array sorted by max increase with bubble sort.");
        return tempArray;
    }

    public int[][] maxDecreaseSort(JaggedArray jagged) {
        int[][] increaseArray = maxIncreaseSort(jagged);
        int[][] tempArray;
        tempArray = new int[increaseArray.length][];
        for(int i = 0; i < increaseArray.length; i++) {
            tempArray[i] = copyArray(increaseArray[increaseArray.length - 1 - i]);
        }
        logger.info("Array sorted by max decrease with bubble sort.");
        return tempArray;
    }

    private int lineMax(int[] line) {
        int max = line[0];
        for(int i = 1; i < line.length; i++) {
            if(line[i] > max) {
                max = line[i];
            }
        }
        return max;
    }

    public int[][] minIncreaseSort(JaggedArray jagged) {
        int[][] tempArray = jagged.getJagged();
        int bound = tempArray.length - 1;
        boolean swapped;
        int[] temp;
        for (int i = 0; i < tempArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < bound; j++) {
                if (lineMin(tempArray[j]) > lineMin(tempArray[j + 1])) {
                    temp = copyArray(tempArray[j]);
                    tempArray[j] = copyArray(tempArray[j + 1]);
                    tempArray[j + 1] = copyArray(temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            bound--;
        }
        logger.info("Array sorted by min increase with bubble sort.");
        return tempArray;
    }

    public int[][] minDecreaseSort(JaggedArray jagged) {
        int[][] increaseArray = minIncreaseSort(jagged);
        int[][] tempArray;
        tempArray = new int[increaseArray.length][];
        for(int i = 0; i < increaseArray.length; i++) {
            tempArray[i] = copyArray(increaseArray[increaseArray.length - 1 - i]);
        }
        logger.info("Array sorted by min decrease with bubble sort.");
        return tempArray;
    }

    private int lineMin(int[] line) {
        int min = line[0];
        for(int i = 1; i < line.length; i++) {
            if(line[i] < min) {
                min = line[i];
            }
        }
        return min;
    }

    private int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return array;
    }
}
