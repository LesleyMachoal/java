import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeFileReader {

    public static void readEmployeeFile(EmployeeArray employeeArray, String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Employees.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String id = tokens[0];
                String firstName = tokens[1];
                String lastName = tokens[2];
                String dateOfBirth = tokens[3];
                String gender = tokens[4];
                String address = tokens[5];
                String city = tokens[6];
                String employmentTitle = tokens[7];
                String dateHired = tokens[8];
                String department = tokens[9];
                double hoursWorked = Double.parseDouble(tokens[10]);
                double rateOfPay = Double.parseDouble(tokens[11]);
                int leaveDays = Integer.parseInt(tokens[12]);
                boolean carAllowance = Boolean.parseBoolean(tokens[13]);
                double monthlyGratuity = Double.parseDouble(tokens[14]);
                double taxRate = Double.parseDouble(tokens[15]);

                Employee employee = new Employee( id, firstName, lastName, dateOfBirth, gender, address, city, employmentTitle,
                 dateHired,  department,  hoursWorked,  rateOfPay, leaveDays, carAllowance, monthlyGratuity, taxRate);

                employeeArray.addEmployee(employee);
            }

            reader.close();

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
