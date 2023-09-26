package pac.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    // создадим кнопки
    JButton btnStart = new JButton("New Game"); // надпись которая отображается на кнопке
    JButton btnExit = new JButton("Exit");
    JButton center = new JButton("center");
    JButton left = new JButton("left");
    JButton right = new JButton("right");

    Map map;
    SettingsWindow setting;
    GameWindow(){ // игровое окно, где задаем его параметры специальными методами, доступными для класса JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // условие закрытия программы (программа завершается вместе с закрытием окна)
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe"); // заголовок окна
        setResizable(false); // запрет изменять размер окна
        map = new Map(); // создали объект панели (экземпляр наследника JPanel)
        setting = new SettingsWindow(this); // добавили панель с настройками, в которую в качестве аргумента передано главное окно

        //add(btnStart, BorderLayout.NORTH); // добавляем кнопку в окно, компановщиком BorderLayout указываем область размещения кнопки
        //add(btnExit, BorderLayout.SOUTH);
        //add(right, BorderLayout.EAST);
        //add(left, BorderLayout.WEST);
        //add(center); // по умолчанию используется BorderLayout по ценртру
        JPanel panBottom = new JPanel(new BorderLayout()); // создаем панель. Является отдельным классом, можно создавать наследников
        panBottom.add(btnStart, BorderLayout.WEST); // в которой размещаем кнопки
        panBottom.add(btnExit, BorderLayout.EAST);
        add(panBottom, BorderLayout.SOUTH); // саму панель также размещаем относительно окна
        btnExit.addActionListener(new ActionListener() { // добавили действие к кнопке
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() { // добавили действие к кнопке
            @Override
            public void actionPerformed(ActionEvent e) {
                setting.setVisible(true); // сделали панель с настройками видимой
            }
        });
//        JPanel panBottom1 = new JPanel(new GridLayout(1, 2)); // создаем вторую панель панель
//        panBottom1.add(left); // в которой размещаем кнопки
//        panBottom1.add(right);
//        add(panBottom1, BorderLayout.NORTH); // саму панель также размещаем относительно окна
        add(map); // добавили панель на наше окно
        setVisible(true); // делаем окно видимым
    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }

    void settingsWindowShow (){

    }
}