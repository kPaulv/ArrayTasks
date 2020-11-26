package com.kiselev.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Array {
    private static final Logger logger = LogManager.getLogger(Array.class.getName());

    int[] array;

    public Array() {
        array = new int[0];
        logger.info("New array created.");
    }

    public Array(int size) {
        array = new int[size];
        logger.info("New array created.");
    }

    public Array(int[] array) {
        int size = array.length;
        this.array = new int[size];
        for(int i = 0; i < size; i++) {
            this.array[i] = array[i];
        }
        logger.info("New array created.");
    }

    public int[] getArray() {
        int[] copyArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
        logger.info("Array set.");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append(", size=").append(array.length);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Array objectArray = (Array) o;
        if(array.length != objectArray.array.length) {
            return false;
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] != objectArray.array[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for(int i = 0; i < array.length; i++) {
            result += this.array[i];
        }
        return result;
    }
}
