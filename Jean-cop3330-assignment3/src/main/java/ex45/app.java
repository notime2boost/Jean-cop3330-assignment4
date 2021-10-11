package ex45;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



class TestWordFinder{



    public static void main(String[] args) throws IOException {


        //scanner to read file
        Scanner s = new Scanner(System.in);



        System.out.print("\nEnter the output file : ");

        String output = s.next();


        //reading file
        ReadFile rf = new ReadFile();



        rf.readile();


        //creating array
        ArrayList<String> list = rf.getdata();


        // creating output file
        WriteFile wr = new WriteFile(output, list);



        wr.writefile();



        System.out.println("\nThe Number of Modifications are : "+wr.getModification());


    }

}






class ReadFile{



    private ArrayList<String> list;
    private Scanner sc;
    private File file;



    public ReadFile() throws FileNotFoundException {

        list = new ArrayList<String>();



        //naming input file name to take
        file = new File("exercise45_input.txt");
        sc = new Scanner(file);

    }

    public void readile(){



        try{

            int i=0;

            while( sc.hasNext() ){


                // read file line by line and store it into list

                String filedata = sc.nextLine();

                list.add(filedata);


            }
        }
        finally{

            sc.close();
        }

    }

    //return the list

    public ArrayList<String> getdata(){

        return list;

    }

}


class WriteFile{


    private FileWriter writer;
    private int count_Modification;
    private ArrayList<String> list;


    public WriteFile(String name, ArrayList<String> list) throws IOException {


        writer = new FileWriter(name);
        this.list = list;


    }


    public void writefile() throws IOException {


        for(int i=0;i<list.size();i++) {

            String temp = list.get(i);

            String str = "utilize";

            int index = 0;


            while (true){

                index = temp.indexOf(str, index);
                if (index != -1){

                    count_Modification ++;
                    index += str.length();
                }
                else{

                    break;
                }
            }

            // modification

            temp = temp.replaceAll("utilize", "use");

            // and write into file

            writer.write(temp+"\n");


        }

        // close the writer object

        writer.close();

    }


    // method that returns the count of modifications

    public int getModification(){

        return count_Modification;

    }


}