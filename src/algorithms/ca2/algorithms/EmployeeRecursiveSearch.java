/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.ca2.algorithms;
import algorithms.ca2.model.Employee;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class EmployeeRecursiveSearch {
    public Employee search(ArrayList<Employee> employees,
                       String targetName, int left, int right) {

     if (left > right) {
        return null;
    }

    int middle = left + (right - left) / 2;

    String middleName = employees.get(middle).getName();

    if (middleName.equalsIgnoreCase(targetName)) {
        return employees.get(middle);
    }

    if (targetName.compareToIgnoreCase(middleName) < 0) {
        return search(employees, targetName, left, middle - 1);
    } else {
        return search(employees, targetName, middle + 1, right);
    }
    
    
}
}
