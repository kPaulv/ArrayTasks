package com.kiselev.task1.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CreateArrayService {
    private static final Logger logger = LogManager.getLogger(CreateArrayService.class.getName());

    public int[] createArray() throws InputMismatchException {
        int size;
        int[] array;
        System.out.println("Enter size: ");
        try (Scanner sc = new Scanner(System.in)) {
            size = sc.nextInt();
            array = new int[size];
            System.out.println("Fill array: ");
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }
            logger.info("Array created from console.");
            return array;
        }
    }

    public int[] createArrayFromFile() throws IOException {
        int size;
        BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int[] array = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        return array;
    }

    public int[] createArrayOfRandom() {
        Random random = new Random();
        int size = random.nextInt(21);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(201) - 100;
        }
        return array;
    }
}
