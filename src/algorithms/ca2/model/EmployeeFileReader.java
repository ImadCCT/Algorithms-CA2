/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.ca2.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class EmployeeFileReader {
    public ArrayList<Employee> readEmployees(String fileName) throws IOException {

        ArrayList<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                // Skip the header row
                if (lineNumber == 1) {
                    continue;
                }

                // Separate the employee information
                String[] data = line.split(",", -1);

                // Check that the row contains three fields
                if (data.length != 3) {
                    System.out.println("Invalid record at line " + lineNumber);
                    continue;
                }

                try {
                    String name = data[0].trim();

                    if (name.isEmpty()) {
                        System.out.println("Empty employee name at line " + lineNumber);
                        continue;
                    }

                    ManagerType managerType =
                            ManagerType.valueOf(data[1].trim().toUpperCase());

                    Department department =
                            Department.valueOf(data[2].trim().toUpperCase());

                    Employee employee =
                            new Employee(name, managerType, department);

                    employees.add(employee);

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid manager type or department at line "
                            + lineNumber);
                }
            }
        }

        return employees;
    }
}
