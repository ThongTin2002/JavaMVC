/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;
import view.MainView;
/**
 *
 * @author ADMIN
 */
// Định nghĩa các phương thức và thuộc tính để làm việc với dữ liệu
public class MainModel {
        private MainView view;
//    public String readFile(File file) throws IOException {
//        StringBuilder content = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line).append("\n");
//            }
//        }
//        return content.toString();
//    }
    public MainModel(MainView view) {
        this.view = view;
    }

    public void readFile(File file) {
        if (file.getName().endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String content = reader.lines().collect(Collectors.joining("\n"));
                view.getTextArea().append(content + "\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveFile(File file, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

}
