package controller;

import model.MainModel;
import view.MainView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.MainModel;

public class MainController {
    private MainView view;
    private MainModel model;

    public MainController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;

        initView();
        initController();
    }
    private void initView() {
        view.setVisible(true);
    }
    private void initController() {
        view.getOpenItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    openFile();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.getSaveItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveFile();
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void openFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnValue = fileChooser.showOpenDialog(view);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile.isDirectory()) {
                traverseDirectory(selectedFile);
            } else {
                model.readFile(selectedFile);
            }
        }
    }

    private void traverseDirectory(File directory) {
        try {
            Files.walk(directory.toPath())
                    .filter(Files::isRegularFile)
                    .forEach(file -> model.readFile(file.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveFile() throws IOException {
        JFileChooser fileChooser = view.getFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showSaveDialog(view);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            model.saveFile(selectedFile, view.getTextArea().getText());
        }
    }
}
