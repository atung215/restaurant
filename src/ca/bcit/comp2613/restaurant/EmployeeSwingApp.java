package ca.bcit.comp2613.restaurant;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.util.EmployeeManagement;

public class EmployeeSwingApp extends JFrame {


	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private NonEditableDefaultTableModel employeeModel;
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name" };
	private JTextField idTextField;
	private JButton btnClose;


	public EmployeeSwingApp() 
	{
		initialize();
		initTable();
	}

	private void initTable() 
	{

		// table = new JTable(swingStudentModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (e.getValueIsAdjusting()) {
							populateFields();
						}
					}
				});
		refreshTable();

	}

	private void populateFields() {
		try {
			idTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString());
			firstNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			lastNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
		} catch (Exception e) {}
	}

	public void doSave() {
		String id = idTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Employee employee = new Employee(id, firstName, lastName, null);
		EmployeeManagement.save(ManagerSwingApp.employees, employee);
		//table.clearSelection();
		refreshTable();
	}
	
	public void doDelete() {
		String id = idTextField.getText();
		Employee employee = new Employee(id, null, null, null);
		EmployeeManagement.delete(ManagerSwingApp.employees, employee);
		refreshTable();
	}
	
	public void doNew() 
	{
		String id = UUID.randomUUID().toString();
		idTextField.setText(id);
		firstNameTextField.setText("");
		lastNameTextField.setText("");
	}

	private void refreshTable() {
		// swingStudentModel = new SwingStudentModel();
		Object[][] data = null;

		data = new Object[ManagerSwingApp.employees.size()][3];
		int i = 0;
		for (Employee employee : ManagerSwingApp.employees) {
			data[i][0] = employee.getId();
			data[i][1] = employee.getFirstName();
			data[i][2] = employee.getLastName();
			i++;
		}
		employeeModel.setDataVector(data, columnNames);
		table.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 601, 499);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		// table = new JTable();
		employeeModel = new NonEditableDefaultTableModel();

		table = new JTable(employeeModel);

		// table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// table.setBounds(0, 11, 585, 247);
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 585, 247);
		this.getContentPane().add(scrollPane);
		// scrollPane.add(table);
		// frame.getContentPane().add(table);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(44, 330, 103, 14);
		this.getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(159, 327, 325, 20);
		this.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(159, 371, 325, 20);
		this.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		this.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		this.getContentPane().add(lblId);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});
		btnSave.setBounds(44, 412, 89, 23);
		this.getContentPane().add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete();
			}
		});
		btnDelete.setBounds(169, 412, 89, 23);
		this.getContentPane().add(btnDelete);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doNew();
			}
		});
		btnNewButton.setBounds(496, 260, 89, 23);
		this.getContentPane().add(btnNewButton);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		this.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeSwingApp.this.dispose();
			}
		});
		btnClose.setBounds(496, 438, 89, 23);
		getContentPane().add(btnClose);
	}
}
