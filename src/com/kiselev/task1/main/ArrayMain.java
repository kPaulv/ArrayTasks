package com.kiselev.task1.main;

import com.kiselev.task1.entity.Array;
import com.kiselev.task1.entity.JaggedArray;
import com.kiselev.task1.report.ArrayReport;
import com.kiselev.task1.report.JaggedArrayReport;
import com.kiselev.task1.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ArrayMain {
    private static final Logger logger = LogManager.getLogger(ArrayMain.class.getName());

    public static void main(String[] args) {
        CreateArrayService createService = new CreateArrayService();
        SortArrayService sortService = new SortArrayService();
        SearchArrayService searchService = new SearchArrayService();
        ArrayReport report = new ArrayReport();
        try {
            //bubble
            int[] array1 = createService.createArray();
            report.showArray(array1);
            Array array = new Array(array1);
            array1 = sortService.bubbleSort(array);
            report.showArray(array1);

            //insertion
            array1 = createService.createArray();
            report.showArray(array1);
            array = new Array(array1);
            array1 = sortService.insertionSort(array);
            report.showArray(array1);

            //selection
            array1 = createService.createArray();
            report.showArray(array1);
            array = new Array(array1);
            array.setArray(sortService.selectionSort(array));
            report.showArray(array1);

            array1 = createService.createArray();
            report.showArray(array1);
            array = new Array(array1);
            int searchNum = 66;
            int index = searchService.binarySearch(array, searchNum);
            report.showNumber(searchNum, index);

            int[] primeArray = searchService.findPrimeNumbers(array);
            Array arrayPrime = new Array(primeArray);
            report.showPrimeArray(arrayPrime);

            int arrayMax = searchService.max(array);
            int arrayMin = searchService.min(array);
            report.showMax(arrayMax);
            report.showMin(arrayMin);

            array1 = createService.createArrayFromFile();
            report.showArray(array1);
            array1 = createService.createArrayOfRandom();
            report.showArray(array1);

            array1 = createService.createArrayFromFile();
            array = new Array(array1);
            int[] threeDigitNumbers = searchService.findThreeDigitNumbers(array);
            Array threeDigit = new Array(threeDigitNumbers);
            report.showThreeDigitArray(threeDigit);

            FibonacciService serviceFibonacci = new FibonacciService();
            int[] fibonacciNumbers = serviceFibonacci.findFibonacciNumbers(array);
            Array fibonacci = new Array(fibonacciNumbers);
            report.showFibonacciArray(fibonacci);

            int[][] jaggedArray = new int[][]{
                    {14, 12, 1, 10},
                    {0, 0, 996},
                    {-1798, 266, 45, 3},
                    {0, 0, 0, 0, 0},
                    {7, 18, 5, 26, 33, 79, 54}
            };
            JaggedArray jagged = new JaggedArray(jaggedArray);
            JaggedArrayReport jaggedReport = new JaggedArrayReport();
            jaggedReport.showArray(jaggedArray);

            SortJaggedService sortJaggedService = new SortJaggedService();
            jaggedArray = sortJaggedService.sumIncreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

            jaggedArray = sortJaggedService.sumDecreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

            jaggedArray = sortJaggedService.maxIncreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

            jaggedArray = sortJaggedService.maxDecreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

            jaggedArray = sortJaggedService.minIncreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

            jaggedArray = sortJaggedService.minDecreaseSort(jagged);
            jaggedReport.showArray(jaggedArray);

        } catch (IOException e) {
            System.out.println("Input Error.");
            logger.error("I0 error.");
        }
    }
}
