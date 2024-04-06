package BaiLam;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;
    private JMenuItem exitMenuItem;
    private JFileChooser fileChooser;

    public View() {
        frame = new JFrame("Simple Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        saveMenuItem = new JMenuItem("Save");
        openMenuItem = new JMenuItem("Open");
        exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(saveMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

        fileChooser = new JFileChooser();
    }

    public void display() {
        frame.setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public int showSaveDialog(Component parent) {
        return fileChooser.showSaveDialog(parent);
    }

    public int showOpenDialog(Component parent) {
        return fileChooser.showOpenDialog(parent);
    }

    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccessDialog(String message) {
        JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
