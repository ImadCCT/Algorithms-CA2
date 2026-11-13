/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.ca2.algorithms;
import algorithms.ca2.model.Employee;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author pc
 */
public class EmployeeBinarySearchTree {

    private class Node {
        Employee employee;
        Node left;
        Node right;

        public Node(Employee employee) {
            this.employee = employee;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert employees in level order
    public void insert(Employee employee) {

        Node newNode = new Node(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    // Display employees using level-order traversal
    public void displayLevelOrder() {

        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            System.out.println(current.employee);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Calculate the height of the tree
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(Node current) {

        if (current == null) {
            return 0;
        }

        int leftHeight = calculateHeight(current.left);
        int rightHeight = calculateHeight(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Count the total number of nodes
    public int countNodes() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node current) {

        if (current == null) {
            return 0;
        }

        return 1 + countNodesRecursive(current.left) + countNodesRecursive(current.right);
    }


}