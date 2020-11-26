package com.kiselev.task1.report;

import com.kiselev.task1.entity.JaggedArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JaggedArrayReport {
    private static final Logger logReport = LogManager.getLogger(ArrayReport.class.getName());

    public void showArray(int[][] jaggedArray) {
        JaggedArray jagged = new JaggedArray(jaggedArray);
        logReport.info("Array: " + jagged.toString());
    }
}
