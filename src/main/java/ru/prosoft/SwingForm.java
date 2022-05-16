package ru.prosoft;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Класс SwingForm содержит методы работы с компонентами GUI
 *
 * @author Sergey Proshchaev
 * @version 1.0
 */
public class SwingForm implements ISwingForm {

    /**
     * Разрешение экрана
     */
    Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Главное окно формы и панели
     */
    JFrame jFrame;
    JPanel mainPanel;
    JPanel filesPanel;
    JPanel protocolPanel;
    JPanel indicatorPanel;

    /**
     * Компоненты GUI
     */
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JComboBox<String> comboBox1;
    String[] elements1;
    JComboBox<String> comboBox2;
    String[] elements2;
    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;

    public JTextArea textArea;
    JProgressBar progressBar;
    Integer progressBarMinimum;
    Integer progressBarMaximum;
    Integer progressBarValue;

    /**
     * Поле класса с обработкой файлов
     */
    private WellFundConverter wellFundConverter;

    /**
     * Создание главного окна (фрейма) в потоке обработки событий
     *
     * @param args
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                //new SwingForm();
                SwingForm swingForm = new SwingForm();

            }
        });
    }


    /**
     * Конструктор класса без параметров, инициализирующий компоненты GUI
     */
    public SwingForm() {

        jFrame = new JFrame("My SWING App");

        jFrame.setSize((int) (screenDimension.width * 0.9), (int) (screenDimension.height * 0.9));
        jFrame.setLocationRelativeTo(null);

        jFrame.setResizable(false);
        jFrame.setIconImage(new ImageIcon("icon.png").getImage());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        jFrame.getContentPane().add(mainPanel);

        filesPanel = new JPanel();
        filesPanel.setBorder(BorderFactory.createTitledBorder("Файлы:"));

        label1 = new JLabel("Груп.");
        filesPanel.add(label1);

        elements1 = new String[]{fillStringSymbol('\u0020', 23)};
        comboBox1 = new JComboBox<>(elements1);
        comboBox1.setPreferredSize(new Dimension(120, 23));


        comboBox1FillFromElements1();
        filesPanel.add(comboBox1);

        label2 = new JLabel("Подгруппа :");
        filesPanel.add(label2);

        comboBox2 = new JComboBox<>(new String[]{fillStringSymbol('\u0020', 25)});
        comboBox2.setPreferredSize(new Dimension(140, 25));

        filesPanel.add(comboBox2);

        textField1 = new JTextField(10);
        filesPanel.add(textField1);

        button1 = new JButton("Открыть");
        filesPanel.add(button1);

        textField2 = new JTextField(10);
        filesPanel.add(textField2);

        button2 = new JButton("Открыть");
        filesPanel.add(button2);

        textField3 = new JTextField(10);
        filesPanel.add(textField3);

        button3 = new JButton("Открыть");
        filesPanel.add(button3);

        textField4 = new JTextField(10);
        filesPanel.add(textField4);

        button4 = new JButton("Открыть");
        filesPanel.add(button4);

        label3 = new JLabel(fillStringSymbol('\u0020', 2));
        filesPanel.add(label3);

        button5 = new JButton("Обработка");
        filesPanel.add(button5);

        comboBox1.addActionListener(new ComboBox1SelectedItem());
        comboBox2.addActionListener(new ComboBox2SelectedItem());
        button1.addActionListener(new Button1Click());
        button2.addActionListener(new Button2Click());
        button3.addActionListener(new Button3Click());
        button4.addActionListener(new Button4Click());
        button5.addActionListener(new Button5Click());

        mainPanel.add(filesPanel, BorderLayout.NORTH);

        protocolPanel = new JPanel();
        protocolPanel.setBorder(BorderFactory.createTitledBorder("Протокол обработки:"));

        textArea = new JTextArea("", (screenDimension.height / 28), (screenDimension.width / 15));

        textArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        textArea.setVisible(true);

        protocolPanel.add(new JScrollPane(textArea));

        mainPanel.add(protocolPanel, BorderLayout.CENTER);

        indicatorPanel = new JPanel();
        indicatorPanel.setBorder(BorderFactory.createTitledBorder("Индикатор выполнения:"));

        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBarMinimum = 0;
        progressBarMaximum = 1000;
        progressBarValue = 0;

        indicatorPanel.add(progressBar);

        mainPanel.add(indicatorPanel, BorderLayout.SOUTH);

        /**
         * Инициализация экземпляра класса с обработкой файлов
         */
        wellFundConverter = new WellFundConverter();

        jFrame.setVisible(true);

    }


    /**
     * Внутренний класс ComboBox1SelectedItem обрабатывает выбор элемента в ComboBox1
     */
    public class ComboBox1SelectedItem implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            wellFundConverter.setComboBox1Value(comboBox1.getSelectedItem().toString());

            textArea.append("ComboBox выбран " + comboBox1.getSelectedItem() + "\n");
            textArea.append("ComboBox2 заполнение элементами..." + "\n");

            comboBox2FillFromElements2();

            textArea.append("ComboBox2 заполнен!" + "\n");

        }
    }

    /**
     * Внутренний класс ComboBox2SelectedItem обрабатывает выбор элемента в ComboBox2
     */
    public class ComboBox2SelectedItem implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (comboBox2.getSelectedItem() != null) {
                wellFundConverter.setComboBox2Value(comboBox2.getSelectedItem().toString());
                textArea.append("ComboBox выбран " + comboBox2.getSelectedItem() + "\n");
            }
        }
    }


    /**
     * Внутренний класс Button1Click обработка нажатия кнопки Button1
     */
    public class Button1Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            FileDialog fileName1 = runFileOpenDialog("Открыть файл 1", "C:\\", "*.xls");

            textField1.setText(fileName1.getFile());
            textArea.append("Выбран " + e.getActionCommand() + " Файл " + fileName1.getFile() + " из " + fileName1.getDirectory() + "\n");

            /**
             * Заносим имя файла в поле имени файла 1 класса с обработкой
             */
            wellFundConverter.setFileInStr1(fileName1.getDirectory() + fileName1.getFile());


        }
    }

    /**
     * Внутренний класс Button2Click обработка нажатия кнопки Button2
     */
    public class Button2Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            FileDialog fileName2 = runFileOpenDialog("Открыть файл 2", "C:\\", "*.xls");

            textField2.setText(fileName2.getFile());
            textArea.append("Выбран " + e.getActionCommand() + " Файл " + fileName2.getFile() + " из " + fileName2.getDirectory() + "\n");

            /**
             * Заносим имя файла в поле имени файла 1 класса с обработкой
             */
            wellFundConverter.setFileInStr2(fileName2.getDirectory() + fileName2.getFile());

        }
    }

    /**
     * Внутренний класс Button3Click обработка нажатия кнопки Button3
     */
    public class Button3Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            FileDialog fileName3 = runFileOpenDialog("Открыть файл 3", "C:\\", "*.xls");

            textField3.setText(fileName3.getFile());
            textArea.append("Выбран " + e.getActionCommand() + " Файл " + fileName3.getFile() + " из " + fileName3.getDirectory() + "\n");

            /**
             * Заносим имя файла в поле имени файла 1 класса с обработкой
             */
            wellFundConverter.setFileInStr3(fileName3.getDirectory() + fileName3.getFile());

        }
    }

    /**
     * Внутренний класс Button4Click обработка нажатия кнопки Button4
     */
    public class Button4Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            FileDialog fileName4 = runFileOpenDialog("Открыть файл 4", "C:\\", "*.xls");

            textField4.setText(fileName4.getFile());
            textArea.append("Выбран " + e.getActionCommand() + " Файл " + fileName4.getFile() + " из " + fileName4.getDirectory() + "\n");

            /**
             * Заносим имя файла в поле имени файла 1 класса с обработкой
             */
            wellFundConverter.setFileInStr4(fileName4.getDirectory() + fileName4.getFile());

        }
    }

    /**
     * Внутренний класс Button5Click обработка нажатия кнопки Button5
     */
    public class Button5Click implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            FileDialog runFileSaveDialog = runFileSaveDialog("Сохранить файл", "C:\\", "*.xls");

            textArea.append("Создание файла: " + runFileSaveDialog.getFile());

            /**
             * Запускаем процесс обработки
             */
            try {
                runWellFundConverter();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            JOptionPane.showMessageDialog(null, "Обработка завершена!",
                    "Информация", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Метод runWellFundConverter вызывает метод (обработчик) из класса WellFundConverter
     *
     * @throws IOException
     */
    private void runWellFundConverter() throws IOException {
        wellFundConverter.runConverter(this);
    }

    /**
     * Метод runFileOpenDialog() запускает диалог выбора файла для открытия
     *
     * @param directory
     * @param fileType
     * @return
     */
    public FileDialog runFileOpenDialog(String title, String directory, String fileType) {

        FileDialog fileDialog = new java.awt.FileDialog(jFrame, title, FileDialog.LOAD);

        fileDialog.setDirectory(directory);
        fileDialog.setFile(fileType);

        fileDialog.setVisible(true);

        return fileDialog;
    }


    /**
     * Метод runFileSaveDialog() запускает диалог сохранения файла
     *
     * @param directory
     * @param fileType
     * @return
     */
    public FileDialog runFileSaveDialog(String title, String directory, String fileType) {

        FileDialog fileDialog = new java.awt.FileDialog(jFrame, title, FileDialog.SAVE);

        fileDialog.setDirectory(directory);
        fileDialog.setFile(fileType);

        fileDialog.setVisible(true);

        return fileDialog;
    }

    /**
     * Метод runFileChooser() вызывает диалог выбора файла на основе Swing компонента JFileChooser (легковесный)
     *
     * @param title заголовок диалогового окна
     * @return
     */
    public File runFileChooser(String title) {
        File file = null;
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setDialogTitle(title);
        int ret = jFileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = jFileChooser.getSelectedFile();
            // ... обработка ...
        }
        return file;
    }

    /**
     * Метод fillElements1() заполняет элементами массив строк elements1
     */
    public void comboBox1FillFromElements1() {

        /**
         * Эмулятор заполнения групп в comboBox1 от 1 до 7
         */
        for (int i = 0; i < 7; i++) {
            comboBox1.addItem(fixString("Группа " + (i + 1), 25) + "!");
        }
    }

    /**
     * Метод fillElements2() заполняет элементами массив строк elements1
     */
    public void comboBox2FillFromElements2() {

        comboBox2.removeAllItems();

        /**
         * Эмулятор заполнения подгрупп в comboBox2 для выбранной группы в comboBox1
         */
        int randomNumber = (int) (Math.random() * 10);
        for (int i = 0; i < randomNumber; i++) {
            comboBox2.addItem(fixString(fixString(comboBox1.getSelectedItem().toString(), 12) + " П/группа "
                    + (i + 1), 25) + "!");
        }
    }

    /**
     * Метод fillStringSymbol формирует строку заданой длинны из заданных символов
     *
     * @param character
     * @param size
     * @return
     */
    public static String fillStringSymbol(char character, int size) {
        char[] charArray = new char[size];
        for (int i = 0; i < size; i++) {
            charArray[i] = character;
        }
        return String.valueOf(charArray);
    }

    /**
     * Метод fixString формирует строку заданной длинны из передаваемой обрезая ее или дополняя пробелами
     *
     * @param string
     * @param fixSize
     * @return
     */
    public static String fixString(String string, int fixSize) {

        if (string.length() < fixSize) {
            char[] resultCharArray = new char[fixSize];
            char[] stringCharArray = string.toCharArray();

            for (int i = 0; i < resultCharArray.length; i++) {

                if (i < stringCharArray.length) {
                    resultCharArray[i] = stringCharArray[i];
                } else {
                    resultCharArray[i] = '\u0020';
                }
            }
            return String.valueOf(resultCharArray);
        } else {
            return string.substring(0, fixSize);
        }
    }

    /**
     * Индикация процесса выполнения
     */
    public void progressBarStep() {
        progressBar.setValue(++progressBarValue);
    }

    /**
     * Переопределение метода из интерфейса ISwingForm
     * Метод textAreaAppend добавляет строку в компонент textArea
     *
     * @param string
     */
    @Override
    public void textAreaAppend(String string) {
        textArea.append(string + "\n");
    }

}

