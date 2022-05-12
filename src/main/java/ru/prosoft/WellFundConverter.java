package ru.prosoft;


import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.format.CellFormatType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import ru.prosoft.SwingForm;

import javax.swing.*;

/**
 * Класс WellFundConverter содержит методы обработки файлов формата MS Excel
 *
 * @author Sergey Proshchaev
 * @version 1.0
 */
public class WellFundConverter {

    /**
     * Поля класса - имена обрабатываемых файлов
     */
    private String comboBox1Value;
    private String comboBox2Value;
    private String fileInStr1;
    private String fileInStr2;
    private String fileInStr3;
    private String fileInStr4;
    private String fileOutStr;
    private XSSFWorkbook excelOutBook;


    /**
     * Запуск обработки файлов fileInStr1, fileInStr2,... fileInStr4
     * и формирование файла fileOutStr
     */
    public void runConverter(JTextArea textArea) throws IOException {

        excelOutBook = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("1.xlsx");
        XSSFSheet excelOutBookSheet = excelOutBook.createSheet("Лист1");

        System.out.println("fileInStr1=" + fileInStr1);
        System.out.println("fileInStr2=" + fileInStr2);
        System.out.println("fileInStr3=" + fileInStr3);
        System.out.println("fileInStr4=" + fileInStr4);


        runFileScan(fileInStr1, textArea);
        runFileScan(fileInStr2, textArea);
        runFileScan(fileInStr3, textArea);
        runFileScan(fileInStr4, textArea);

        //swingForm.progressBarStep();

        excelOutBook.write(fileOut);
        fileOut.close();

    }

    /**
     * Метод runFileScan() сканирует файлы MS Excel с однотипной структурой
     * @param fileInStr
     */
    private void runFileScan(String fileInStr, JTextArea textArea) throws IOException {

        textArea.append("Обработка " + fileInStr + "...");

        XSSFWorkbook excelInBook = new XSSFWorkbook(new FileInputStream(fileInStr));
        XSSFSheet excelInBookSheet = excelInBook.getSheetAt(0); // getSheet("Лист1"); // или по индексу листа

        //

        System.out.println("getFirstRowNum()=" + excelInBookSheet.getFirstRowNum());
        System.out.println("getLastRowNum()=" + excelInBookSheet.getLastRowNum());

        excelInBook.close();

        textArea.append("Обработка " + fileInStr + " завершена!");

    }


    /**
     * Геттеры и сеттеры полей класса
     */
    public String getComboBox1Value() {
        return comboBox1Value;
    }

    public void setComboBox1Value(String comboBox1Value) {
        this.comboBox1Value = comboBox1Value;
    }

    public String getComboBox2Value() {
        return comboBox2Value;
    }

    public void setComboBox2Value(String comboBox2Value) {
        this.comboBox2Value = comboBox2Value;
    }

    public String getFileInStr1() {
        return fileInStr1;
    }

    public void setFileInStr1(String fileInStr1) {
        this.fileInStr1 = fileInStr1;
    }

    public String getFileInStr2() {
        return fileInStr2;
    }

    public void setFileInStr2(String fileInStr2) {
        this.fileInStr2 = fileInStr2;
    }

    public String getFileInStr3() {
        return fileInStr3;
    }

    public void setFileInStr3(String fileInStr3) {
        this.fileInStr3 = fileInStr3;
    }

    public String getFileInStr4() {
        return fileInStr4;
    }

    public void setFileInStr4(String fileInStr4) {
        this.fileInStr4 = fileInStr4;
    }

    public String getFileOutStr() {
        return fileOutStr;
    }

    public void setFileOutStr(String fileOutStr) {
        this.fileOutStr = fileOutStr;
    }

    /**
     * Метод readFromCell читает значение из ячейки листа MS Excel
     *
     * @param - XSSFSheet excelSheet имя листа
     * @param - int row строка ячейки
     * @param - int column столбец ячейки
     * @return - String значение ячейки в текстовом формате
     */
    private static String readFromCell(XSSFSheet excelSheet, int row, int column) {
        String resultReadFromCell = "null";

        XSSFRow rowObj = excelSheet.getRow(row);
        XSSFCell cellObj;

        if (rowObj != null) {
            cellObj = rowObj.getCell(column);
            resultReadFromCell = cellObj.toString();
        }
        return resultReadFromCell;
    }

}
