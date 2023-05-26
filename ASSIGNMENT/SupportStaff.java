public class SupportStaff extends Employee {

    private String department;

    public SupportStaff(String id, String firstName, String lastName, String gender, String address, String cityOrTown, String employeeTitle,
                               String dateHired, double hoursWorked, double rateOfPay, int leaveDays,
                               boolean carAllowance, double monthlyGratuity, String department) {
        super(id, firstName, lastName, gender, address, cityOrTown, employeeTitle, dateHired, hoursWorked, rateOfPay, leaveDays, carAllowance, monthlyGratuity);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "department= " + department;
    }
}
