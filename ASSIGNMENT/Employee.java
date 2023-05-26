import java.time.LocalDate;
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String city;
    private String employmentTitle;
    private String dateHired;
    private String department;
    private double hoursWorked;
    private double rateOfPay;
    private int leaveDays;
    private boolean carAllowance;
    private double monthlyGratuity;
    private double taxRate;
   
    
    public Employee(String id, String firstName, String lastName, String dateOfBirth, String gender, String address,String city, String employmentTitle, String dateHired, String department, double hoursWorked, double rateOfPay, int leaveDays,boolean carAllowance, double monthlyGratuity, double taxRate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.employmentTitle = employmentTitle;
        this.dateHired = dateHired;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.rateOfPay = rateOfPay;
        this.leaveDays = leaveDays;
        this.carAllowance = carAllowance;
        this.monthlyGratuity = monthlyGratuity;
        this.taxRate = taxRate;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public void setFullName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCity(String city) {
        this.city = city;
    }
     public String getCity() {
        return this.city;
    }

    public String getEmploymentTitle() {
        return employmentTitle;
    }
    
    public void setEmploymentTitle(String employmentTitle) {
        this.employmentTitle = employmentTitle;
    }
    
    public String getDateHired() {
        return dateHired;
    }
    
    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public double getRateOfPay() {
        return rateOfPay;
    }
    
    public void setRateOfPay(double rateOfPay) {
        this.rateOfPay = rateOfPay;
    }
    
    public int getLeaveDays() {
        return leaveDays;
    }
    
    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }
    
    public double getMonthlyGratuity() {
        return monthlyGratuity;
    }
    
    public void setMonthlyGratuity(double monthlyGratuity) {
          this.monthlyGratuity = monthlyGratuity;

    }
   
   public double getTaxRate() {
       return taxRate;
   }
   public double calculateTax1(){
      return rateOfPay * 0.15;
   }
   
      public double calculateTax2(){
      return rateOfPay * 0.3;
   }

   public void setTaxRate(double taxRate) {
       this.taxRate = taxRate;
   }
   
   public boolean hasCarAllowance() {
      
           return carAllowance;
       }
   
    public void setCarAllowance(boolean carAllowance) {
       this.carAllowance = carAllowance;
}

   public double calculateSalary() {
          double salary = 0.0;
          if (employmentTitle.equals("HR Officer") || employmentTitle.equals("Accounts Officer")) {
              salary = hoursWorked * rateOfPay + monthlyGratuity + calculateTax1();
          } else if (employmentTitle.equals("CEO")) {
              salary = hoursWorked * rateOfPay + monthlyGratuity + calculateTax2() + (carAllowance ? 5000 : 0);
          } else {
              salary = hoursWorked * rateOfPay + getTaxRate();
          }
          return salary;
      }

   public double getGrossPay() {
       return hoursWorked * rateOfPay + monthlyGratuity;
   }
   
   public double getNetPay() {
       return getGrossPay() * (1 - taxRate);
   }
   

   public String toString() {
       return "------------Employee Details-------------" + "\n" +
               "ID: " + id + "\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Date of Birth: " + dateOfBirth + "\n" +
               "Gender: " + gender + "\n" +
               "City: " + city + "\n" +
               "Address: " + address + "\n" +
               "Title of Employment: " + employmentTitle + "\n" +
               "Date Hired: " + dateHired + "\n" +
               "Department: " + department + "\n" +
               "Hours Worked: " + hoursWorked + "\n" +
               "Rate of Pay: " + rateOfPay + "\n" +
               "Leave Days: " + leaveDays + "\n" +
               "Car Allowance: " + hasCarAllowance() + "\n" +
               "Monthly Gratuity: " + monthlyGratuity + "\n" +
               "Tax Rate: " + taxRate + "\n" +
               "Gross Pay: " + getGrossPay() + "\n" +
               "Net Pay: " + getNetPay() + "\n";
   }
 }
   