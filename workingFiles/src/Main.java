import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //createFile();
        getInfo();
        readFile();
        writeFile();
        readFile();
    }

    public static void createFile(){
        File file = new File("your file path\\workingFiles\\files\\student.txt");
        try {
            if(file.createNewFile()){
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void getInfo(){
        File file = new File("your file path\\workingFiles\\files\\student.txt");
        if(file.exists()){
            System.out.println("File name: " + file.getName());
            System.out.println("File path: " + file.getAbsolutePath());
            System.out.println("Is file writable? : " + file.canWrite());
            System.out.println("Is file readable? : " + file.canRead());
            System.out.println("File size (bytes) : " + file.length());
        }
    }

    public static void readFile(){
        File file = new File("your file path\\workingFiles\\files\\student.txt");
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("your file path\\workingFiles\\files\\student.txt", true));  // true appends to the existing content, false overwrites it
            writer.newLine();
            writer.write("ALAZGIR");
            System.out.println("Data written to the file.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
