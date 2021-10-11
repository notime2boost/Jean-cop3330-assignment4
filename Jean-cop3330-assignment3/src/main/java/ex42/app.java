/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Jean
 */
package ex42;

import java.util.*;
import java.io.*;

class Employee {


    public void printDetails(String filename) {
        try {
            //assigning new file a name
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            while (sc.hasNext()) {
                // reading data on input file
                String s = sc.nextLine();
                // organizing array data on console
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }


    public static void main(String[] args) {

        Employee emp = new Employee();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.printDetails("exercise42_input.txt");
    }
}