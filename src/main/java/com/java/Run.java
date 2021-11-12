package com.java;
import java.io.IOException;
public class Run {
    public static void main(String[] args) throws IOException {
        ReadExcel readExcel = new ReadExcel();
        readExcel.readExcelFile();
        readExcel.convertObjects2JsonString();
    }
}
