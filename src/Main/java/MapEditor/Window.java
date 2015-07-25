package MapEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends Canvas implements ActionListener {

    private Main main;

    public Window(Main main) {
        this.main = main;

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

        bar.add(menu);

        JFrame frame = new JFrame("MapEditor");
        frame.setPreferredSize(new Dimension(main.width, main.height));
        frame.setMaximumSize(new Dimension(main.width, main.height));
        frame.setMinimumSize(new Dimension(main.width, main.height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(main);
        frame.add(bar, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New...") {
            main.New();
        } else if (e.getActionCommand() == "Import") {
            main.Import();
        } else if (e.getActionCommand() == "Export") {
            main.Export();
        }
    }
}
