package todoapp;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private static final String FILE_NAME = "tasks.txt"; // file to store tasks

    public ToDoApp() {
        setTitle("To-Do List App");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Title
        JLabel titleLabel = new JLabel("My Tasks", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Task list
        taskListModel = new DefaultListModel<>();
        loadTasksFromFile(); // load existing tasks
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Task input field with placeholder
        taskField = new JTextField();
        taskField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        taskField.setForeground(Color.GRAY);
        taskField.setText("Enter a new task...");
        taskField.setBorder(BorderFactory.createCompoundBorder(
                taskField.getBorder(),
                new EmptyBorder(5, 5, 5, 5)));

        taskField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (taskField.getText().equals("Enter a new task...")) {
                    taskField.setText("");
                    taskField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (taskField.getText().isEmpty()) {
                    taskField.setForeground(Color.GRAY);
                    taskField.setText("Enter a new task...");
                }
            }
        });

        inputPanel.add(taskField, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));

        addButton = new JButton("Add Task");
        styleButton(addButton, new Color(76, 175, 80)); // green
        addButton.addActionListener(e -> addTask());

        deleteButton = new JButton("Delete Task");
        styleButton(deleteButton, new Color(244, 67, 54)); // red
        deleteButton.addActionListener(e -> deleteTask());

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        inputPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void styleButton(JButton button, Color bgColor) {
    button.setFocusPainted(false);
    button.setForeground(Color.WHITE);
    button.setFont(new Font("Segoe UI", Font.BOLD, 14));
    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    button.setContentAreaFilled(false); // we will handle painting
    button.setOpaque(false);

    button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    // Custom rounded paint
    button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Background with rounded corners
            g2.setColor(bgColor);
            g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);

            super.paint(g, c);
            g2.dispose();
        }
    });
}


    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty() && !task.equals("Enter a new task...")) {
            taskListModel.addElement(task);
            saveTasksToFile();
            taskField.setText("");
            taskField.setForeground(Color.GRAY);
            taskField.setText("Enter a new task...");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
            saveTasksToFile();
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < taskListModel.size(); i++) {
                writer.write(taskListModel.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving tasks!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    taskListModel.addElement(line);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading tasks!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}
