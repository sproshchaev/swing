package ru.prosoft;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SwingForm {

    public static void main(String[] args) {

        /**
         * Создание фрейма в потоке обработки событий
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createSwingForm();
            }
        });


    }

    public static void createSwingForm() {

        /**
         * Создание контейнера верхнего уровня с заголовком (окна с заданными размерами и заголовком)
         */
        JFrame jFrame = new JFrame("My SWING App");
        int height = 350 * 2; // 300
        int width = 750 * 2;  // 550

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

        JLabel label1 = new JLabel("Груп."); // todo НГДУ (max 25)
        String[] elements1 = new String[] {"Группа 1                .", "Группа 2", "Группа 3", "Группа 4", "Группа 5",  "Группа 6",  "Группа 7"};
        JComboBox<String> comboBox1 = new JComboBox<>(elements1);

        JLabel label2 = new JLabel("Подгруппа :"); // todo Месторожд.: (max 23)
        String[] elements2 = new String[] {"Подгруппа 1           .", "Подгруппа 2", "Подгруппа 3", "Подгруппа 4", "Подгруппа 5"};
        JComboBox<String> comboBox2 = new JComboBox<>(elements2);

        JTextField textField1 = new JTextField(10);
        JButton button1 = new JButton("Открыть");
        // button1.addActionListener(this); // todo переделать статику в класс

        JTextField textField2 = new JTextField(10);
        JButton button2 = new JButton("Открыть");

        JTextField textField3 = new JTextField(10);
        JButton button3 = new JButton("Открыть");

        JTextField textField4 = new JTextField(10);
        JButton button4 = new JButton("Открыть");

        JLabel label3 = new JLabel("                         ");
        JButton buttonRun = new JButton("Обработка");

        filesPanel.add(label1);
        filesPanel.add(comboBox1);

        filesPanel.add(label2);
        filesPanel.add(comboBox2);

        filesPanel.add(textField1);
        filesPanel.add(button1);

        filesPanel.add(textField2);
        filesPanel.add(button2);

        filesPanel.add(textField3);
        filesPanel.add(button3);

        filesPanel.add(textField4);
        filesPanel.add(button4);

        filesPanel.add(label3);
        filesPanel.add(buttonRun);

        mainPanel.add(filesPanel, BorderLayout.NORTH);

        /**
         * Панель "Протокол обработки"
         */
        JPanel scanPanel = new JPanel();
        Border scanPanelBorder = BorderFactory.createTitledBorder("Протокол обработки:");
        scanPanel.setBorder(scanPanelBorder);

        JTextArea textArea = new JTextArea("Многострочное поле", 27, 130);
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
