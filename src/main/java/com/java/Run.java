package com.java;

import java.util.List;

import static com.java.ReadExcel.readExcelFile;

public class Run {
    public static void main(String[] args) {
        List<Students> student = readExcelFile("C:\\Users\\Udhayakumar\\IdeaProjects\\Excel2JSON\\src\\exls.xlsx");
        String jsonString = ReadExcel.convertObjects2JsonString(student);
        System.out.println(jsonString);
    }
}
