package de.thunderfrog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {
    public static Double version = 1.0;
    public static String Path, Filename,action;
    public static Systemlog Console = new Systemlog();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Console.Log("Welcome to dir2list" + version);
        InputPath();
    }

    public static void InputPath(){
        // Path
        Console.Log("Please enter the full Path:");
        Path = in.nextLine();

        // Filename
        Console.Log("Please enter the Filename:");
        Filename = in.nextLine() + ".txt";
        CreateFile();

        Console.Log("(E)xit or (R)estart ? ");
        action = in.nextLine();
        CheckAction();

    }
    // Create File with Input
    public static void CreateFile(){
        try {
            File myFile = new File("Output/" + Filename);

            if (myFile.createNewFile()) {
                Console.Log("File created: " + myFile.getName());
            } else {
                Console.Log("File already exists.");
            }
        } catch (IOException e) {
            Console.Log("An error occurred.");
            e.printStackTrace();
        }
    }


    public static void dir2file(String Path, String Filename) throws IOException {
        Files.list(new File(Path).toPath())
                .forEach(path -> {
                    Console.Log(path.toString());
                });
    }

    // Check Input End or Restart
    public static void CheckAction(){
        if(action.equals("E") || action.equals("e")){
            Console.Log("Exit Program");
            System.exit(0);
        }else if(action.equals("R") || action.equals("r")){
            Console.Log("Restart Program");
            InputPath();
        }

    }


}
