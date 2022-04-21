package ru.prosoft;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SwingForm {

    public static void main(String[] args) {

        
        createSwingForm();

    }

    public static void createSwingForm() {

        /**
         * Создание контейнера верхнего уровня (окна с заданными размерами и заголовком)
         */
        JFrame jFrame = new JFrame("My SWING App");
        int height = 350 * 2; // 300
        int width = 550 * 2;  // 500

        /**
         * Отключение изменения размеров окна
         */
        jFrame.setResizable(false);

        /**
         * Иконка окна
         */
        ImageIcon icon = new ImageIcon("icon.png");
        jFrame.setIconImage(icon.getImage());

        /**
         * Варианты определения размера и положения главной формы
         * "setSizeSetLocation" - с использованием setSize(), setLocation ()
         * "setBounds" - c использованием setBounds()
         * "useToolKit" - с использованием полученных разрешений экрана
         */
        String methodLocation = "useToolKit";
        switch (methodLocation) {
            case  "setSizeSetLocation":
                jFrame.setSize(width, height);
                jFrame.setLocation(500, 300);
                break;
            case "setBounds":
                jFrame.setBounds(500, 300, width, height);
                break;
            case "useToolKit":
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension dimension = toolkit.getScreenSize();
                jFrame.setBounds(dimension.width/2 - width/2, dimension.height/2 - height/2, width, height);
                break;
        }

        /**
         * Обработка закрытия окна
         */
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Главная панель формы
         */
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        jFrame.getContentPane().add(mainPanel);

        //
        JPanel filesPanel = new JPanel();
        Border filesPanelBorder = BorderFactory.createTitledBorder("Файлы:");
        filesPanel.setBorder(filesPanelBorder);

        JTextField textField1 = new JTextField(10);
        JButton button1 = new JButton("Открыть");

        JTextField textField2 = new JTextField(10);
        JButton button2 = new JButton("Открыть");

        JTextField textField3 = new JTextField(10);
        JButton button3 = new JButton("Открыть");

        JTextField textField4 = new JTextField(10);
        JButton button4 = new JButton("Открыть");

        JLabel label = new JLabel("Месторожд.:");
        String[] elements = new String[] {"Месторождение 1", "Месторождение 1", "Месторождение 3", "Месторождение 4", "Месторождение 5"};
        JComboBox<String> comboBox = new JComboBox<>(elements);
        comboBox.setSize(200, 300);

        JButton buttonRun = new JButton("Run");

        filesPanel.add(textField1);
        filesPanel.add(button1);

        filesPanel.add(textField2);
        filesPanel.add(button2);

        filesPanel.add(textField3);
        filesPanel.add(button3);

        filesPanel.add(textField4);
        filesPanel.add(button4);

        filesPanel.add(label);
        filesPanel.add(comboBox);

        filesPanel.add(buttonRun);

        mainPanel.add(filesPanel, BorderLayout.NORTH);

        /**
         * Панель "Сканирование"
         */
        JPanel scanPanel = new JPanel();
        Border scanPanelBorder = BorderFactory.createTitledBorder("Протокол обработки:");
        scanPanel.setBorder(scanPanelBorder);

        JTextArea textArea = new JTextArea("Многострочное поле", 27, 96);
        textArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        textArea.setTabSize(10);
        textArea.setSize(200, 200);
        textArea.setVisible(true);

        scanPanel.add(new JScrollPane(textArea));

        mainPanel.add(scanPanel, BorderLayout.CENTER);

        //
        JPanel processPanel = new JPanel();
        Border processPanelBorder = BorderFactory.createTitledBorder("Индикатор выполнения:");
        processPanel.setBorder(processPanelBorder);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);

        // Настройка параметрой UI-представителя
        UIManager.put("ProgressBar.cellSpacing", 2);
        UIManager.put("ProgressBar.cellLength", 6);
        processPanel.add(progressBar);

        mainPanel.add(processPanel, BorderLayout.SOUTH);


        /**
         * Установка свойства видимости окна
         */
        jFrame.setVisible(true);

    }

}
