/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author ADMIN
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class MainView extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private JMenuItem openItem;
    private JMenuItem saveItem;

    public MainView() {
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        setUpMenuBar();
        setVisible(true);
    }

    private void initComponents() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        fileChooser = new JFileChooser();
    }

    private void setUpMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }
    public JMenuItem getSaveItem() {
        return saveItem;
    }    
    public JTextArea getTextArea() {
        return textArea;
    }
    public JFileChooser getFileChooser() {
        return fileChooser;
    }
}
