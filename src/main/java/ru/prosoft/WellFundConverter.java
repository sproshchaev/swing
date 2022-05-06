package ru.prosoft;


/**
 * Класс WellFundConverter содержит методы обработки файлов формата MS Excel
 */
public class WellFundConverter {

    /**
     * Поля класса
     */
    private String fileInStr1;
    private String fileInStr2;
    private String fileInStr3;
    private String fileInStr4;

    private String fileOutStr;


    /**
     * Запуск обработки файлов fileInStr1, fileInStr2,... fileInStr4
     * и формирование файла fileOutStr
     */
    public void runConverter() {

        /**
         * Эмуляция процесса обработки
         */
        for (int i = 0; i <= 1000; i++) {
            //swingForm.progressBarStep();
        }

    }

    /**
     * Геттеры и сеттеры полей класса
     */
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
