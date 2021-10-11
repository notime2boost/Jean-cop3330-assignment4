/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Christopher Jean
 */
package ex44;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReadFromTheFile {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        try{
            //Read json file

            Object obj = parser.parse(new FileReader("D:/products.json"));
           // read internal value

            JSONObject jsonObject = (JSONObject)obj;
            //readding file for data

            JSONArray subjects = (JSONArray)jsonObject.get("products");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String input;
            /
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();

            //iterator for data

            Iterator iterator = subjects.iterator();
            //going thorough iterator
            while (iterator.hasNext()) {

                JSONObject json = (JSONObject) iterator.next();

                //Get the name value

                String name = (String)json.get("name");

                //compare data with input

                if(input.toLowerCase().equals(name.toLowerCase())){
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            //0 if not found 1 if found
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}