public class EmployeeArray {
    public Employee[] employees;
    public int size;
    public final int MAX_SIZE = 15;
	//creating a array named employees which will holds the MAX_SIZE
    public EmployeeArray() {
        employees = new Employee[MAX_SIZE];
        size = 0;
    }

	//void method which will add employees to the employee array, will also check if the array if full or not.
    public void addEmployee(Employee employee) {
        if (size < MAX_SIZE) {
            employees[size] = employee;
            size++;
             
        } else {
            System.out.println("Error: Array is full");

        }
    }
    public void updateEmployee(String id) {
    
         boolean found = false;
         
         for (int i = 0; i < size; i++) { 
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

}
