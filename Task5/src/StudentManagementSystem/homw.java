package StudentManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.TextArea;

public class homw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homw frame = new homw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public homw() {
		setTitle("CODESOFT.com");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1312, 662);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 46, 1263, 48);
		panel.setBackground(Color.CYAN);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label = new Label("STUDENT MANAGEMENT SYSTEM");
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(0, 0, 536, 38);
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GREEN);
		tabbedPane.setBounds(0, 115, 1298, 510);
		contentPane.add(tabbedPane);
		
		Panel panel_1 = new Panel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(0, 9, 427, 452);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(179, 20, 227, 19);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(179, 49, 227, 19);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 78, 227, 19);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 107, 227, 19);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(36, 23, 63, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRollNumber.setBounds(36, 52, 91, 16);
		panel_2.add(lblRollNumber);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGrade.setBounds(36, 81, 91, 16);
		panel_2.add(lblGrade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEmail.setBounds(36, 110, 91, 16);
		panel_2.add(lblEmail);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBackground(UIManager.getColor("Button.background"));
		btnUpdate.setBounds(10, 199, 89, 21);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(UIManager.getColor("Button.background"));
		btnDelete.setBounds(10, 230, 89, 21);
		panel_2.add(btnDelete);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBackground(UIManager.getColor("Button.background"));
		btnSave.setBounds(10, 263, 89, 21);
		panel_2.add(btnSave);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBackground(UIManager.getColor("Button.background"));
		btnDisplay.setBounds(10, 294, 89, 21);
		panel_2.add(btnDisplay);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setBounds(10, 168, 89, 21);
		panel_2.add(btnNewButton_1);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(Color.GREEN);
		panel_3.setBounds(445, 0, 816, 472);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(10, 9, 796, 39);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		Label label_1 = new Label("Search Student");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		label_1.setBounds(10, 8, 108, 21);
		panel_4.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(124, 10, 96, 19);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(260, 10, 85, 21);
		panel_4.add(btnNewButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefresh.setBounds(355, 10, 85, 21);
		panel_4.add(btnRefresh);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(Color.CYAN);
		panel_5.setBounds(10, 54, 795, 409);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		String[] columns = {"Name", "Roll Number", "Grade", "Email"};
		DefaultTableModel model = new DefaultTableModel(columns, 0);  // 0 = no rows
		JTable table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Name", "Roll Number", "Grade", "Email"
			}
		));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 775, 390); // Proper size inside panel_5
		panel_5.add(scrollPane); // Add to the correct panel


	}
}
