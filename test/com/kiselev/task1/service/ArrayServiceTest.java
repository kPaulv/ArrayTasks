package com.kiselev.task1.service;

import com.kiselev.task1.entity.Array;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ArrayServiceTest {
    @Test
    public void arrayTest() {
        try {
            CreateArrayService createService = new CreateArrayService();
            SortArrayService sortService = new SortArrayService();
            int[] actualArr = createService.createArrayFromFile();
            int[] expectedArr = new int[]{5, 2, 17, 22, 65, 43, 198, -56, 0, 0, 122, 0, 246, -3659, 7, 498632, 10, 1};
            Array actualArray = new Array(actualArr);
            Array expectedArray = new Array(expectedArr);
            assertEquals(actualArray, expectedArray);
            actualArr = sortService.bubbleSort(actualArray);
            expectedArr = new int[]{-3659, -56, 0, 0, 0, 1, 2, 5, 7, 10, 17, 22, 43, 65, 122, 198, 246, 498632};
            actualArray = new Array(actualArr);
            expectedArray = new Array(expectedArr);
            assertEquals(actualArray, expectedArray);
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }
}
