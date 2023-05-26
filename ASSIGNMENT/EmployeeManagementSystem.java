import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmployeeManagementSystem extends JFrame implements ActionListener {
    private EmployeeArray array = new EmployeeArray();
    private EmployeeFileReader read = new EmployeeFileReader();
    private Employee[] employees;
    private int numEmployees;
    private Employee[] employeeArray;
    private EmployeeForm employeeForm;

    private JButton readButton;
    private JButton addButton;
    private JButton showAllButton;
    private JButton searchByTitleButton;
    private JButton displayMaleButton;
    private JButton displayFemaleButton;
    private JButton displaySalaryButton;
    private JButton searchByEmployeeButton;
    private JButton displayByCityButton;
    private JButton deleteByCityButton;
    private JButton updateButton;

    public EmployeeManagementSystem() {
        employees = new Employee[15];
        numEmployees = 0;
        employeeArray = new Employee[15];
        employeeForm = new EmployeeForm();
        Color buttonBackgroundColor = Color.BLUE;

        addButton = new JButton("Add Employee");
        addButton.addActionListener(this);
        addButton.setBackground(buttonBackgroundColor);

        showAllButton = new JButton("Show All Employees");
        showAllButton.addActionListener(this);
        showAllButton.setBackground(buttonBackgroundColor);

        searchByTitleButton = new JButton("Search by Title");
        searchByTitleButton.addActionListener(this);
        searchByTitleButton.setBackground(buttonBackgroundColor);

        displayMaleButton = new JButton("Display Male Employees");
        displayMaleButton.addActionListener(this);
        displayMaleButton.setBackground(buttonBackgroundColor);

        displayFemaleButton = new JButton("Display Female Employees");
        displayFemaleButton.addActionListener(this);
        displayFemaleButton.setBackground(buttonBackgroundColor);

        displaySalaryButton = new JButton("Display All Salaries");
        displaySalaryButton.addActionListener(this);
        displaySalaryButton.setBackground(buttonBackgroundColor);

        searchByEmployeeButton = new JButton("Search by Employee");
        searchByEmployeeButton.addActionListener(this);
        searchByEmployeeButton.setBackground(buttonBackgroundColor);

        displayByCityButton = new JButton("Display Employees by City");
        displayByCityButton.addActionListener(this);
        displayByCityButton.setBackground(buttonBackgroundColor);

        deleteByCityButton = new JButton("Delete Employees by City");
        deleteByCityButton.addActionListener(this);
        deleteByCityButton.setBackground(buttonBackgroundColor);

        updateButton = new JButton("Update Employees");
        updateButton.addActionListener(this);
        updateButton.setBackground(buttonBackgroundColor);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);
        buttonPanel.add(searchByTitleButton);
        buttonPanel.add(displayMaleButton);
        buttonPanel.add(displayFemaleButton);
        buttonPanel.add(displaySalaryButton);
        buttonPanel.add(searchByEmployeeButton);
        buttonPanel.add(displayByCityButton);
        buttonPanel.add(deleteByCityButton);
        buttonPanel.add(updateButton);

        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(new JLabel("Employee Management System"), BorderLayout.NORTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            employeeForm.setVisible(true);
        } else if (e.getSource() == showAllButton) {
            displayEmployees();
        } else if (e.getSource() == searchByTitleButton) {
            searchByTitle();
        } else if (e.getSource() == displayMaleButton) {
            displayMaleEmployees();
        } else if (e.getSource() == displayFemaleButton) {
            displayFemaleEmployees();
        } else if (e.getSource() == displaySalaryButton) {
            displaySalaries();
        } else if (e.getSource() == searchByEmployeeButton) {
            searchByEmployee();
        } else if (e.getSource() == displayByCityButton) {
            displayEmployeesByCity();
        } else if (e.getSource() == deleteByCityButton) {
            deleteEmployeesPerCity("gaborone");
        } else if (e.getSource() == updateButton) {
            updateEmployee("001");
        }
    }

   public void addEmployee() {
        employeeForm.addEmployee();
    }
    
    private void displayEmployees() {
    if (numEmployees == 0) {
        JOptionPane.showMessageDialog(this, "No employees to display.");
        return;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numEmployees; i++) {
        sb.append(employees[i].toString()).append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

private void searchByTitle() {
    String employmentTitle = JOptionPane.showInputDialog(this, "Enter title to search for:");
    boolean found = false;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].getEmploymentTitle().equalsIgnoreCase(employmentTitle)) {
            sb.append(employees[i].toString()).append("\n");
            found = true;
        }
    }

    if (!found) {
        JOptionPane.showMessageDialog(this, "No employees found with that title.");
    } else {
        JOptionPane.showMessageDialog(this, sb.toString());
    }
}

private void displayMaleEmployees() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].getGender().equalsIgnoreCase("male")) {
            sb.append(employees[i].toString()).append("\n");
        }
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

private void displayFemaleEmployees() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].getGender().equalsIgnoreCase("female")) {
            sb.append(employees[i].toString()).append("\n");
        }
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

private void displaySalaries() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numEmployees; i++) {
        sb.append(employees[i].getFullName()).append(":P ").append(employees[i].calculateSalary()).append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

private void searchByEmployee() {
    String FirstName = JOptionPane.showInputDialog(this, "Enter employee first name:");
    String LastName = JOptionPane.showInputDialog(this, "Enter employee last name:");
    String FullName = FirstName + " " + LastName;

    boolean found = false;

    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].getFullName().equalsIgnoreCase(FullName)) {
            JOptionPane.showMessageDialog(this, employees[i].getFullName() + "'s salary is P" + employees[i].calculateSalary());
            found = true;
            break;
        }
    }

    if (!found) {
        JOptionPane.showMessageDialog(this, "Employee not found.");
    }
}

private void displayEmployeesByCity() {
    HashMap<String, Integer> cityCounts = new HashMap<>();

    for (int i = 0; i < numEmployees; i++) {
        String city = employees[i].getCity();
        if (cityCounts.containsKey(city)) {
            cityCounts.put(city, cityCounts.get(city) + 1);
        } else {
            cityCounts.put(city, 1);
        }
    }

    StringBuilder sb = new StringBuilder();
    for (String city : cityCounts.keySet()) {
        sb.append(city).append(": ").append(cityCounts.get(city)).append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
 }
 
  private void deleteEmployeesPerCity(String city) {
    int numDeleted = 0;

    for (int i = 0; i < numEmployees; i++) {
        if (employees[i].getCity().equals(city)) {
            // Shift all subsequent elements left
            for (int j = i + 1; j < numEmployees; j++) {
                employees[j - 1] = employees[j];
            }
            numEmployees--;
            i--;
            numDeleted++;
        }
    }

    JOptionPane.showMessageDialog(this, "Deleted " + numDeleted + " employees from " + city);
  }
  public void updateEmployee(String id) {
    
         boolean found = false;
         
         for (int i = 0; i < numEmployees; i++) { 
            if (employees[i] != null && employees[i].getId().equals(id)) {
               found = true;
               employees[i] = null;
               System.out.println("Employee with ID " + id + " has been deleted.");
            break;
            }
         }
         if (!found) {
            System.out.println("Error: Employee with ID " + id + " not found.");
         }
    }    

 public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeManagementSystem();
            }
        });
    }
}

