/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Jean
 */
package ex41;

import java.io.*;

import java.util.*;


class NameSorter{

    //  read the data from Scanner object to the ArrayList

    public static void readNames(Scanner input, ArrayList<String> names) {

        // reading the data

        while (input.hasNextLine()){

            // adding data to the list of names

            names.add(input.nextLine());
        }
    }



    public static void outputNames(ArrayList<String> names) throws IOException{

        // creating the output file

        FileWriter output = new FileWriter("exercise41_output.txt");

        // writing output file

        output.write("Total of " + names.size() + " names\n");

        output.write("--------------------\n");

        // writing the names in the file


        for (String i : names){

            output.write(i + "\n");

        }

        // closing the output

        output.close();

    }

    public static void main(String[] args) throws FileNotFoundException{

        //to read  input file

        Scanner inputFile = new Scanner(new File("exercise41_input.txt"));

        //  storing the names

        ArrayList<String> names = new ArrayList<String>();

        // reading the names from the input file

        readNames(inputFile, names);

        // sorting the list of names

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        // closing scanner object

        inputFile.close();

        // writing output file

        try {
            outputNames(names);
        }


        catch (Exception e){
            System.out.println(e);
        }
    }
}