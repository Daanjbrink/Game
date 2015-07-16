package com.Malloten;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(Main main) {

        JFrame frame = new JFrame("Game");

        frame.setPreferredSize(new Dimension(640, 480));
        frame.setMaximumSize(new Dimension(640, 480));
        frame.setMinimumSize(new Dimension(640, 480));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(main);
        frame.setVisible(true);
    }
}
