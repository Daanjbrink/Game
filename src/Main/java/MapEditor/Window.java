package MapEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends Canvas implements ActionListener {

    public Window(Main main) {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem New = new JMenuItem("New...");
        New.addActionListener(this);
        menu.add(New);

        JSeparator sep = new JSeparator();
        menu.add(sep);

        JMenuItem Import = new JMenuItem("Import");
        Import.addActionListener(this);
        menu.add(Import);

        JMenuItem Export = new JMenuItem("Export");
        Export.addActionListener(this);
        menu.add(Export);

        JFrame frame = new JFrame("MapEditor");
        frame.setPreferredSize(new Dimension(main.width, main.height));
        frame.setMaximumSize(new Dimension(main.width, main.height));
        frame.setMinimumSize(new Dimension(main.width, main.height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(bar);
        frame.add(main);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
