
package StudentManagementSystem;


		
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;

public class StudentManagementSystem extends JFrame {
    private static final long serialVersionUID = 1L;

    private ArrayList<Student> students = new ArrayList<>();
    private JTable table;
    private DefaultTableModel model;

    public StudentManagementSystem() {
    	getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
        setTitle("Student Management System");
        setSize(898, 572);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel(new String[]{"Name", "Roll Number", "Grade", "Email"}, 0);
        table = new JTable(model);
        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        table.setFont(new Font("Times New Roman", Font.BOLD, 14));

        loadStudents();

        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        JButton searchBtn = new JButton("Search");
        JButton saveBtn = new JButton("Save");

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(searchBtn);
        buttonPanel.add(saveBtn);

        getContentPane().add(new JScrollPane(table), BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addStudent());
        editBtn.addActionListener(e -> editStudent());
        deleteBtn.addActionListener(e -> deleteStudent());
        searchBtn.addActionListener(e -> searchStudent());
        saveBtn.addActionListener(e -> saveStudents());

        setVisible(true);
    }

    private void addStudent() {
        JTextField nameField = new JTextField();
        JTextField rollField = new JTextField();
        JTextField gradeField = new JTextField();
        JTextField emailField = new JTextField();

        Object[] fields = {
                "Name:", nameField,
                "Roll Number:", rollField,
                "Grade:", gradeField,
                "Email:", emailField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText().trim();
                int roll = Integer.parseInt(rollField.getText().trim());
                String grade = gradeField.getText().trim();
                String email = emailField.getText().trim();

                if (name.isEmpty() || grade.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Student s = new Student(name, roll, grade, email);
                students.add(s);
                model.addRow(new Object[]{name, roll, grade, email});
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Roll number must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void editStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to edit.");
            return;
        }

        Student s = students.get(selectedRow);

        JTextField nameField = new JTextField(s.name);
        JTextField rollField = new JTextField(String.valueOf(s.rollNumber));
        JTextField gradeField = new JTextField(s.grade);
        JTextField emailField = new JTextField(s.email);

        Object[] fields = {
                "Name:", nameField,
                "Roll Number:", rollField,
                "Grade:", gradeField,
                "Email:", emailField
        };

        int result = JOptionPane.showConfirmDialog(null, fields, "Edit Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText().trim();
                int roll = Integer.parseInt(rollField.getText().trim());
                String grade = gradeField.getText().trim();
                String email = emailField.getText().trim();

                if (name.isEmpty() || grade.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                s.name = name;
                s.rollNumber = roll;
                s.grade = grade;
                s.email = email;

                model.setValueAt(name, selectedRow, 0);
                model.setValueAt(roll, selectedRow, 1);
                model.setValueAt(grade, selectedRow, 2);
                model.setValueAt(email, selectedRow, 3);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Roll number must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteStudent() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            students.remove(selectedRow);
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        }
    }

    private void searchStudent() {
        String input = JOptionPane.showInputDialog(this, "Enter roll number to search:");
        if (input != null) {
            try {
                int roll = Integer.parseInt(input.trim());
                for (Student s : students) {
                    if (s.rollNumber == roll) {
                        JOptionPane.showMessageDialog(this, "Found:\nName: " + s.name + "\nGrade: " + s.grade + "\nEmail: " + s.email);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Student not found.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid roll number.");
            }
        }
    }

    private void saveStudents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"))) {
            oos.writeObject(students);
            JOptionPane.showMessageDialog(this, "Data saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }

    private void loadStudents() {
        File file = new File("students.ser");
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            students = (ArrayList<Student>) ois.readObject();
            for (Student s : students) {
                model.addRow(new Object[]{s.name, s.rollNumber, s.grade, s.email});
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading saved data.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementSystem::new);
    }
}
