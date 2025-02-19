import com.gopichand.beans.Employee;
import com.gopichand.factory.ConnectionFactory;
import com.gopichand.factory.EmployeeServiceFactory;
import com.gopichand.service.EmployeeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static
    {
        ConnectionFactory.getConnection();
        EmployeeServiceFactory.getEmployeeService();
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Employee Management System");
        System.out.println("===================================");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
        int eno = 0;
        String ename = "";
        float esal = 0.0f;
        String eaddr = "";
        Employee employee = null;
        String status = "";
        while (true) {
            System.out.println();
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice[1,2,3,4,5]: ");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Employee Add Module :");
                    System.out.println("=============================");
                    System.out.print("Enter Employee Number: ");
                    eno = Integer.parseInt(br.readLine());
                    Employee emp= employeeService.searchEmployee(eno);
                    if(emp == null) {
                        System.out.print("Enter Employee Name: ");
                        ename = br.readLine();
                        System.out.print("Enter Employee Salary: ");
                        esal = Float.parseFloat(br.readLine());
                        System.out.print("Enter Employee Address: ");
                        eaddr = br.readLine();

                        employee = new Employee();
                        employee.setEno(eno);
                        employee.setEname(ename);
                        employee.setEsal(esal);
                        employee.setEaddr(eaddr);

                        status = employeeService.addEmployee(employee);
                        if (status.equalsIgnoreCase("SUCCESS")) {
                            System.out.println("Employee Added Successfully");
                        }
                        if (status.equalsIgnoreCase("FAILURE")) {
                            System.out.println("Employee Not Added Successfully");
                        }
                    }
                    else {
                        System.out.println("Employee Exists Already");
                    }
                    break;
                case 2:
                    System.out.println("Employee Search Module :");
                    System.out.println("=============================");
                    System.out.print("Enter Employee Number: ");
                    eno = Integer.parseInt(br.readLine());
                    employee = employeeService.searchEmployee(eno);
                    if (employee != null) {
                        System.out.println("Employee Details");
                        System.out.println("=============================");
                        System.out.println("Employee Number : " + employee.getEno());
                        System.out.println("Employee Name   : " + employee.getEname());
                        System.out.println("Employee Salary : " + employee.getEsal());
                        System.out.println("Employee Address : " + employee.getEaddr());
                    }
                    else {
                        System.out.println("Employee Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Employee Update Module :");
                    System.out.println("=============================");
                    System.out.print("Enter Employee Number: ");
                    eno = Integer.parseInt(br.readLine());
                    employee = employeeService.searchEmployee(eno);
                    //Employee Name
                    if(employee != null) {
                        System.out.print("Employee Name  Old: "+employee.getEname()+" New: ");
                        ename = br.readLine();
                        if(ename==null || ename.equals("")) {
                            ename =employee.getEname();
                        }
                        //Employee Salary
                        System.out.print("Employee Salary Old: "+employee.getEsal()+" New: ");
                        String sal = br.readLine();
                        if(sal==null || sal.equals("")) {
                            esal = employee.getEsal();
                        }
                        else{
                            esal = Float.parseFloat(sal);
                        }
                        //Employee Address
                        System.out.print("Employee Address Old: "+employee.getEaddr()+" New: ");
                        eaddr = br.readLine();
                        if(eaddr==null || eaddr.equals("")) {
                            eaddr =employee.getEaddr();
                        }

                        Employee employee1 = new Employee();
                        employee1.setEno(eno);
                        employee1.setEname(ename);
                        employee1.setEsal(esal);
                        employee1.setEaddr(eaddr);

                        status = employeeService.updateEmployee(employee1);
                        if (status.equalsIgnoreCase("SUCCESS")) {
                            System.out.println("Employee Updated Successfully");
                        }
                        if (status.equalsIgnoreCase("FAILURE")) {
                            System.out.println("Employee Not Updated Successfully");
                        }
                    }
                    else {
                        System.out.println("Employee Not Found");
                    }

                    break;
                case 4:
                    System.out.println("Employee Delete Module :");
                    System.out.println("=============================");
                    System.out.print("Enter Employee Number: ");
                    eno = Integer.parseInt(br.readLine());
                    employee = employeeService.searchEmployee(eno);
                    if(employee != null)
                    {
                        status = employeeService.deleteEmployee(eno);
                        if (status.equalsIgnoreCase("SUCCESS"))
                        {
                            System.out.println("Employee Deleted Successfully");
                        }
                        if(status.equalsIgnoreCase("FAILURE"))
                        {
                            System.out.println("Employee Not Deleted Successfully");
                        }
                    }
                    else
                    {
                        System.out.println("Employee Not Found");
                    }

                    break;
                case 5:
                    System.out.println("Thank you for using our Employee Management System");
                    ConnectionFactory.closeConnection();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, Please Provide the valid choice from the list");
                    break;
            }
        }
    }
}