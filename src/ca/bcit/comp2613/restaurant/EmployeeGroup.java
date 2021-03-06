package ca.bcit.comp2613.restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSeparator;

import ca.bcit.comp2613.restaurant.model.Employee;
import ca.bcit.comp2613.restaurant.model.Manager;

public class EmployeeGroup extends JFrame {

	private JTable table;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JLabel lblLastName;
	private JLabel lblId;
	private NonEditableDefaultTableModel swingStudentModel;
	public String[] columnNames = new String[] { "id", "First Name",
			"Last Name", "Hourly Rate" };
	private JTextField idTextField;
	private Manager manager;
	private JButton btnClose;
	private JTextField addTextField;
	private JLabel lblStudentId;
	private JLabel lblhourlyRate;

	public EmployeeGroup(Manager manager) 
	{
		this.manager = manager;
		this.setTitle(manager.getFirstName() + " " + manager.getLastName() + "' s Group");
		initialize();
		initTable();
	}

	private void initTable() 
	{
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

	private void populateFields()
	{
		try 
		{
			idTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 0).toString());
			firstNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 1).toString());
			lastNameTextField.setText(table.getModel()
					.getValueAt(table.getSelectedRow(), 2).toString());
		} catch (Exception e) {
		}
	}

	public void removeFromClass() {
		String id = idTextField.getText();
		
		//Student student = new Student(id, null, null);
		//TeacherUtil.removeFromClass (teacher, student);
		ManagerSwingApp.customQueryHelper.removeEmployeesFromManager(manager.getId(), Long.parseLong(id));
		refreshTable();
	}

	public void doAdd() {
		try {
			String id = addTextField.getText();
			ManagerSwingApp.customQueryHelper.addEmployeesToManager(manager.getId(), Long.parseLong(id));
		} catch (Exception e) {}
		refreshTable();
	}

	private void refreshTable() 
	{
		// swingStudentModel = new SwingStudentModel();
		Object[][] data = null;
		List<Employee> employees = ManagerSwingApp.customQueryHelper.getEmployeesOfManager(manager.getId());
		if (employees != null) {
			data = new Object[employees.size()][4];
			int i = 0;
			for (Employee employee : employees) 
			{
				data[i][0] = employee.getId();
				data[i][1] = employee.getFirstName();
				data[i][2] = employee.getLastName();
				data[i][3] = "$ " + employee.getHourlyRate();
				i++;
			}
			swingStudentModel.setDataVector(data, columnNames);
			table.repaint();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 601, 704);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		// table = new JTable();
		swingStudentModel = new NonEditableDefaultTableModel();

		table = new JTable(swingStudentModel);

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
		firstNameTextField.setEditable(false);
		firstNameTextField.setBounds(159, 327, 325, 20);
		this.getContentPane().add(firstNameTextField);
		firstNameTextField.setColumns(10);

		lastNameTextField = new JTextField();
		lastNameTextField.setEditable(false);
		lastNameTextField.setBounds(159, 371, 325, 20);
		this.getContentPane().add(lastNameTextField);
		lastNameTextField.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(44, 374, 77, 14);
		this.getContentPane().add(lblLastName);

		lblId = new JLabel("id");
		lblId.setBounds(44, 288, 46, 14);
		this.getContentPane().add(lblId);
		
		lblhourlyRate = new JLabel("Hourly Rate");
		lblhourlyRate.setBounds(44, 400, 46, 14);
		this.getContentPane().add(lblhourlyRate);

		JButton btnRemove = new JButton("Remove From Group");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromClass();
			}
		});
		btnRemove.setBounds(32, 413, 252, 23);
		this.getContentPane().add(btnRemove);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAdd();
			}
		});
		btnAdd.setBounds(252, 594, 89, 23);
		this.getContentPane().add(btnAdd);

		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setBounds(159, 285, 325, 20);
		this.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeGroup.this.dispose();
			}
		});
		btnClose.setBounds(496, 643, 89, 23);
		getContentPane().add(btnClose);
		
		addTextField = new JTextField();
		addTextField.setBounds(301, 556, 86, 20);
		getContentPane().add(addTextField);
		addTextField.setColumns(10);
		
		lblStudentId = new JLabel("Employee ID To Add");
		lblStudentId.setBounds(159, 562, 125, 14);
		getContentPane().add(lblStudentId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(182, 413, 1, 2);
		getContentPane().add(separator);
	}
}
