package com.kiselev.task1.main;

import com.kiselev.task1.entity.Array;
import com.kiselev.task1.report.ArrayReport;
import com.kiselev.task1.service.CreateArrayService;
import com.kiselev.task1.service.FibonacciService;
import com.kiselev.task1.service.SearchArrayService;
import com.kiselev.task1.service.SortArrayService;
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



        } catch (IOException e) {
            System.out.println("Input Error.");
            logger.error("I0 error.");
        }
    }
}
