import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class employeeSalaries {
    public static void main(String[] args) {
        // Instantiate the object of DecimalFormat
        DecimalFormat dF = new DecimalFormat("0.00");

        // Try block
        try {
            // Set the input/output file
            // Input file
            String fileName = "C:/Users/User/swc2333/employeeSalaries.txt";
            BufferedReader inputFile = new BufferedReader(new FileReader(fileName));

            // 2 output files
            PrintWriter topPerformingEmployee = new PrintWriter(new FileWriter("top-performing employee.txt"));
            PrintWriter empLeastYears = new PrintWriter(new FileWriter("employee with least years of service.txt"));

            // Declare the variables
            String inputData = null;
            String empName ;
            int baseSalary , yearsOfService ;
            String performing ;
            double annualSal ;

            // Write the employee name and annual salary for top performing employee
            topPerformingEmployee.println("List top-performing employee");
            topPerformingEmployee.println("\nEmployee Name\t\tAnual Salary");
            topPerformingEmployee.println("--------------------------------------");

            // Write the employee name and employee with least years of service
            empLeastYears.println("List of employee with least years of service");
            empLeastYears.println("\n\nEmployee Name\t\tAnnual Salary");
            empLeastYears.println("--------------------------------------");

            while ((inputData = inputFile.readLine()) != null) {
                // Instantiate the object reference of the StringTokenizer class
                // to read the string line (input data) & to set the delimeter
                StringTokenizer sT = new StringTokenizer(inputData, ";");

                // to pass the string line &delimeter
                // Break into tokens and assign to the appropriate variables
                empName = sT.nextToken();
                baseSalary = Integer.parseInt(sT.nextToken());
                yearsOfService = Integer.parseInt(sT.nextToken());

                // to calculate annual Salary
                annualSal = baseSalary + (baseSalary * 0.05);

                // To determine the annual salary and write the data to the appropriate output file
                if (annualSal > 60000) {
                    topPerformingEmployee.println(empName + "\t\t\t" + annualSal);
                } else if (yearsOfService >= 3) {
                    empLeastYears.println(empName + "\t\t\t" + annualSal);
                }
            } // end of while

            // Close all the input/output files
            inputFile.close();
            topPerformingEmployee.close();
            empLeastYears.close();
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Problem :" + e.getMessage());
        }
    }
}