/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithms.ca2;
import algorithms.ca2.model.Employee;
import algorithms.ca2.model.EmployeeFileReader;
import java.util.ArrayList;
import java.io.IOException;
import algorithms.ca2.algorithms.EmployeeMergeSort;
import algorithms.ca2.algorithms.EmployeeRecursiveSearch;
import algorithms.ca2.algorithms.EmployeeBinarySearchTree;
/**
 *
 * @author pc
 */
public class AlgorithmsCA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EmployeeFileReader reader = new EmployeeFileReader();
        System.out.println("Working directory: "  + System.getProperty("user.dir"));

    System.out.println("File exists: "  + java.nio.file.Files.exists( java.nio.file.Paths.get("data/Applicants_Form.txt")));

    try {
        
        ArrayList<Employee> employees = reader.readEmployees("data/Applicants_Form.txt");
        EmployeeBinarySearchTree tree = new EmployeeBinarySearchTree();

        for (Employee employee : employees) {
        tree.insert(employee);
        }
        
        EmployeeMergeSort sorter = new EmployeeMergeSort();

        ArrayList<Employee> sortedEmployees = sorter.mergeSort(employees);
        EmployeeRecursiveSearch searcher = new EmployeeRecursiveSearch();
        Employee found = searcher.search(sortedEmployees, "Ethan Clark", 0, sortedEmployees.size() - 1);
        if (found != null) {
        System.out.println("\nEmployee found: " + found);
        } else {
        System.out.println("\nEmployee not found.");
        }

        System.out.println("===== EMPLOYEE FILE TEST =====");

        System.out.println("Total employees loaded: " + employees.size());

        System.out.println("\n===== EMPLOYEE RECORDS =====");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("\n===== EMPLOYEES SORTED ALPHABETICALLY =====");

        for (Employee employee : sortedEmployees) {
        System.out.println(employee);
        }
        System.out.println("\n===== EMPLOYEE BINARY TREE (LEVEL ORDER) =====");
        tree.displayLevelOrder();

    } catch (IOException e) {
        System.out.println("Error reading employee file: "  + e.getMessage());
       }
    }
    
}
