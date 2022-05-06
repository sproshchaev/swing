package ru.prosoft;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    public void runConverter() throws IOException {

        excelOutBook = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("1.xlsx");
        XSSFSheet excelOutBookSheet = excelOutBook.createSheet("Лист1");

        runFileScan(fileInStr1);
        runFileScan(fileInStr2);
        runFileScan(fileInStr3);
        runFileScan(fileInStr4);

        //swingForm.progressBarStep();

        excelOutBook.write(fileOut);
        fileOut.close();

    }

    /**
     * Метод runFileScan() сканирует файлы MS Excel с однотипной структурой
     * @param fileInStr
     */
    private void runFileScan(String fileInStr) throws IOException {
        // XSSFWorkbook excelInBook = new XSSFWorkbook(new FileInputStream(fileInStr));
        // XSSFSheet excelInBookSheet = excelInBook.getSheet("Лист1"); // или по индексу листа

        // excelInBook.close();
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
}
