/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Jean
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;



class Word_Frequency_Finder {

    public static void main(String[] args) throws FileNotFoundException {



        ReadInputFile rf = new ReadInputFile();

        rf.readfile();


        HashMap<String, Integer> map = rf.getMap();


        PrintReport pr = new PrintReport(map);

        pr.printScreen();

    }

}



class ReadInputFile{


    private Scanner sc;
    private File file;
    private HashMap<String, Integer> map;

    public ReadInputFile() throws FileNotFoundException {

        file = new File("exercise46_input.txt");
        sc = new Scanner(file);
        map = new HashMap<String,Integer>();

    }

    public void readfile() {

        try{

            while( sc.hasNext() ){

                // read input whole line

                String input = sc.nextLine();

                // split it by spaces

                String arr[] = input.split(" ");

                // using for loop

                for(int i=0;i<arr.length;i++){

                    String key = arr[i];

                    // if key is already in map then

                    if(map.containsKey(key)){

                        // update value by 1

                        int value = map.get(key);

                        value++;

                        map.put(key, value);

                    }

                    // else put it in the map

                    else {

                        map.put(key, 1);

                    }

                }


            }
        }
        finally {
            sc.close();
        }

    }


    public HashMap<String, Integer> getMap(){

        return map;

    }

}


class PrintReport{



    private HashMap<String, Integer> map;

    // constructor

    public PrintReport( HashMap<String, Integer> map) {

//       initialize constructor

        this.map = map;

    }


    // method for print histogram on screen

    public void printScreen() {

        // declare arrays to store keys and values

        String keys[] = new String[map.size()];

        Integer values[] = new Integer[map.size()];

        int k=0;

        // iterate map ans store array

        for (Entry<String, Integer> entry : map.entrySet()) {

            keys[k] = entry.getKey();

            values[k++] = entry.getValue();

        }

        // declare another arrays of String and Integer to Store values

        int tempvalues[] = new int[map.size()];

        String tempkeys[] = new String[map.size()];

        // duplicate values arrays to tempvalues

        for(int i=0;i<values.length;i++) {

            tempvalues[i] = values[i];

        }


        // reverse sort values array

        Arrays.sort(values, Collections.reverseOrder());


        // sort keys array according to values array and store in tempkeys

        for(int i=0; i<map.size();i++) {

            int value = values[i];

            for(int j=0; j<tempvalues.length;j++) {

                if(value == tempvalues[j]) {

                    tempkeys[i] = keys[j];

                    break;

                }

            }

        }

        System.out.println();

        // print hostogram

        for(int i=0;i<map.size();i++) {

            int value = map.get(tempkeys[i]);


            System.out.print(tempkeys[i]+" : \t");


            for(int j=0; j<value; j++) {

                System.out.print("*");

            }

            System.out.println();

        }


    }


}