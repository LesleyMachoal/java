import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class EmployeeForm extends JFrame {
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dateOfBirthField;
    private JTextField genderField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField employmentTitleField;
    private JTextField dateHiredField;
    private JTextField departmentField;
    private JTextField hoursWorkedField;
    private JTextField rateOfPayField;
    private JTextField leaveDaysField;
    private JTextField carAllowanceField;
    private JTextField monthlyGratuityField;
    private JTextField taxRateField;
    private JTextArea employeeListArea;

    private int numEmployees;
    private Employee[] employees;

    public EmployeeForm() {
        numEmployees = 0;
        employees = new Employee[10]; // Change the size as per your requirement

        setTitle("Employee Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create labels and fields for employee information
        JPanel formPanel = new JPanel(new GridLayout(17, 2));
        formPanel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        formPanel.add(idField);
        formPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        formPanel.add(firstNameField);
        formPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        formPanel.add(lastNameField);
        formPanel.add(new JLabel("Date of Birth (MM/DD/YYYY):"));
        dateOfBirthField = new JTextField();
        formPanel.add(dateOfBirthField);
        formPanel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        formPanel.add(genderField);
        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        formPanel.add(addressField);
        formPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        formPanel.add(cityField);
        formPanel.add(new JLabel("Employment Title:"));
        employmentTitleField = new JTextField();
        formPanel.add(employmentTitleField);
        formPanel.add(new JLabel("Date Hired (MM/DD/YYYY):"));
        dateHiredField = new JTextField();
        formPanel.add(dateHiredField);
        formPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        formPanel.add(departmentField);
        formPanel.add(new JLabel("Hours Worked:"));
        hoursWorkedField = new JTextField();
        formPanel.add(hoursWorkedField);
        formPanel.add(new JLabel("Rate of Pay:"));
        rateOfPayField = new JTextField();
        formPanel.add(rateOfPayField);
        formPanel.add(new JLabel("Leave Days:"));
        leaveDaysField = new JTextField();
        formPanel.add(leaveDaysField);
        formPanel.add(new JLabel("Car Allowance (true/false):"));
        carAllowanceField = new JTextField();
        formPanel.add(carAllowanceField);
        formPanel.add(new JLabel("Monthly Gratuity:"));
        monthlyGratuityField = new JTextField();
        formPanel.add(monthlyGratuityField);
        formPanel.add(new JLabel("Tax Rate:"));
        taxRateField = new JTextField();
        formPanel.add(taxRateField);

        // Create the "Add Employee" button
        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        // Create the employee list area
        employeeListArea = new JTextArea();
        employeeListArea.setEditable(false);

        // Add the components to the main frame
        add(formPanel, BorderLayout.NORTH);
        add(addButton, BorderLayout.CENTER);
        add(new JScrollPane(employeeListArea), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void addEmployee() {
        if (numEmployees >= employees.length) {
            JOptionPane.showMessageDialog(this, "Maximum number of employees reached.");
            return;
        }

        String id = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String dateOfBirth = dateOfBirthField.getText();
        String gender = genderField.getText();
        String address = addressField.getText();
        String city = cityField.getText();
        String employmentTitle = employmentTitleField.getText();
        String dateHired = dateHiredField.getText();
        String department = departmentField.getText();
        double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
        double rateOfPay = Double.parseDouble(rateOfPayField.getText());
        int leaveDays = Integer.parseInt(leaveDaysField.getText());
        boolean carAllowance = Boolean.parseBoolean(carAllowanceField.getText());
        double monthlyGratuity = Double.parseDouble(monthlyGratuityField.getText());
        double taxRate = Double.parseDouble(taxRateField.getText());

        Employee employee = new Employee(id, firstName, lastName, dateOfBirth, gender, address, city,
                employmentTitle, dateHired, department, hoursWorked, rateOfPay, leaveDays, carAllowance,
                monthlyGratuity, taxRate);

        employees[numEmployees] = employee;
        numEmployees++;

        employeeListArea.append(employee.toString() + "\n");

        // Save employee information to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt", true))) {
            writer.write(employee.toString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving employee data to file.");
        }

        clearFields();
    }
     private void clearFields() {
        idField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");
        dateOfBirthField.setText("");
        genderField.setText("");
        addressField.setText("");
        cityField.setText("");
        employmentTitleField.setText("");
        dateHiredField.setText("");
        departmentField.setText("");
        hoursWorkedField.setText("");
        rateOfPayField.setText("");
        leaveDaysField.setText("");
        carAllowanceField.setText("");
        monthlyGratuityField.setText("");
        taxRateField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }
}
    
