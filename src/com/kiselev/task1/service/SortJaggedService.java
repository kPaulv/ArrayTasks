package com.kiselev.task1.service;

import com.kiselev.task1.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortJaggedService {
    private static final Logger logger = LogManager.getLogger(SortJaggedService.class.getName());
    /*•в порядке возрастания (убывания) сумм элементов строк матрицы;
    •в порядке возрастания (убывания) максимальных элементов строк матрицы;
    •в порядке возрастания (убывания) минимальных элементов строк матрицы.*/
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
        int[][] tempArray = jagged.getJagged();
        int bound = tempArray.length - 1;
        boolean swapped;
        int[] temp;
        for (int i = 0; i < tempArray.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < bound; j++) {
                if (lineSum(tempArray[j]) < lineSum(tempArray[j + 1])) {
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

    private int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return array;
    }
}
