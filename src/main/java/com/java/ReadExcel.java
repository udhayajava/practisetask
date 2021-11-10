package com.java;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadExcel {
    public static List<Students> readExcelFile(String filePath) {
        try {
            FileInputStream excelFile = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            LinkedList list = new LinkedList();
            int rowNum = 0;
            while (rows.hasNext()) {
                XSSFRow row = (XSSFRow) rows.next();
                if (rowNum == 0) {
                    rowNum++;
                    continue;
                }
                Iterator cells = row.iterator();
                Students students = new Students();
                int cellIndex = 0;
                while (cells.hasNext()) {
                    XSSFCell cell = (XSSFCell) cells.next();
                    if (cellIndex == 0) {
                        students.setRollNum((int) cell.getNumericCellValue());
                    } else if (cellIndex == 1) {
                        students.setName(cell.getStringCellValue());
                    } else if (cellIndex == 2) {
                        students.setAge((int) cell.getNumericCellValue());
                    } else if (cellIndex == 3) {
                        students.setMarks((int) cell.getNumericCellValue());
                    }
                    cellIndex++;
                }
                list.add(students);

            }
            workbook.close();
            return list;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }

    }

    public static String convertObjects2JsonString(List<Students> list) {
        File file1;
        try { Scanner scan = new Scanner(System.in);
            System.out.println("Name Your File with .json");
            String filename1 = scan.nextLine();
            String directory = System.getProperty("user.dir");
            String path;
            path = directory + File.separator + filename1;
            System.out.println("Filepath is " + path);

            file1 = new File(path);
            boolean result1;
            try {
                result1 = file1.createNewFile();
                if (result1) {
                    System.out.println("File Generated Successfully" + file1.getCanonicalPath());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            JSONObject object = new JSONObject();
            object.put("Personal details",list);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename1));
            bufferedWriter.write(object.toJSONString());
            bufferedWriter.close();
            System.out.println("Json File is created successfully");
        } catch (IOException e) {
            System.out.println("Already file is created");
        }
        return null;
    }
}
