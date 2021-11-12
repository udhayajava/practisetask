package com.java;


import java.io.IOException;
import java.sql.ClientInfoStatus;

public class Run {
    public static void main(String[] args) throws IOException {
        ReadExcel readExcel = new ReadExcel();
        readExcel.readExcelFile();
        readExcel.convertObjects2JsonString();
    }
}
