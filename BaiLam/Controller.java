package BaiLam;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        // Attach event listeners
        view.display();
        attachListeners();
    }

    private void attachListeners() {
        view.getSaveMenuItem().addActionListener(e -> saveToFile());
        view.getOpenMenuItem().addActionListener(e -> loadFromFile());
        view.getExitMenuItem().addActionListener(e -> System.exit(0));
    }

    private void saveToFile() {
        int result = view.showSaveDialog(view.getFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = view.getFileChooser().getSelectedFile();
            try (PrintWriter writer = new PrintWriter(file)) {
                String text = view.getText();
                writer.print(text);
                view.showSuccessDialog("File saved successfully.");
            } catch (IOException e) {
                view.showErrorDialog("Error saving file: " + e.getMessage());
            }
        }
    }

    private void loadFromFile() {
        int result = view.showOpenDialog(view.getFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = view.getFileChooser().getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                model.setLines(List.of(text.toString().split("\n")));
                view.setText(text.toString());
                view.showSuccessDialog("File loaded successfully.");
            } catch (IOException e) {
                view.showErrorDialog("Error loading file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View();
            new Controller(model, view);
        });
    }
}
