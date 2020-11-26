package com.kiselev.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class JaggedArray {
    private static final Logger logger = LogManager.getLogger(JaggedArray.class.getName());

    int[][] jagged;

    public JaggedArray(int[][] jagged) {
        this.jagged = new int[jagged.length][];
        for(int i = 0; i < jagged.length; i++) {
            this.jagged[i] = new int[jagged[i].length];
        }
        for(int i = 0; i < jagged.length; i++) {
            for(int j = 0; j < jagged[i].length; j++) {
                this.jagged[i][j] = jagged[i][j];
            }
        }
        logger.info("New jagged array created.");
    }

    public int[][] getJagged() {
        return jagged;
    }

    public int get(int i, int j) {
        return jagged[i][j];
    }

    public void setJagged(int[][] jagged) {
        this.jagged = jagged;
        logger.info("Jagged array set.");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggedArray{");
        sb.append("jagged=");
        for(int i = 0; i < jagged.length - 1; i++) {
            sb.append(Arrays.toString(jagged[i])).append(", ");
        }

        sb.append(Arrays.toString(jagged[jagged.length - 1])).append('}');
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

        JaggedArray that = (JaggedArray) o;

        if(jagged.length != that.jagged.length) {
            return false;
        }
        for(int i = 0; i < jagged.length; i++) {
            if(jagged[i].length != that.jagged[i].length) {
                return false;
            }
        }
        for(int i = 0; i < jagged.length; i++) {
            for(int j = 0; j < jagged[i].length; j++) {
                if(jagged[i][j] != that.jagged[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for(int i = 0; i < jagged.length; i++) {
            for(int j = 0; j < jagged.length; j++) {
                result += jagged[i][j];
            }
        }
        return result;
    }
}
