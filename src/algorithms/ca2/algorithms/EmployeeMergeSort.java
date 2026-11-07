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
public class EmployeeMergeSort {
    public ArrayList<Employee> mergeSort(ArrayList<Employee> employees) {

        if (employees.size() <= 1) {
            return employees;
        }

        int middle = employees.size() / 2;

        ArrayList<Employee> left = new ArrayList<>(
                employees.subList(0, middle));

        ArrayList<Employee> right = new ArrayList<>(
                employees.subList(middle, employees.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
private ArrayList<Employee> merge(ArrayList<Employee> left,ArrayList<Employee> right) {

    ArrayList<Employee> result = new ArrayList<>();

    int i = 0;
    int j = 0;

    while (i < left.size() && j < right.size()) {

        if (left.get(i).getName().compareToIgnoreCase(
                right.get(j).getName()) <= 0) {

            result.add(left.get(i));
            i++;

        } else {

            result.add(right.get(j));
            j++;
        }
    }

    while (i < left.size()) {
        result.add(left.get(i));
        i++;
    }

    while (j < right.size()) {
        result.add(right.get(j));
        j++;
    }

    return result;
}

    }

