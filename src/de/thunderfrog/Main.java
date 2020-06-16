package de.thunderfrog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Double version = 1.0;
    public static String Path, Filename,action;
    public static Systemlog Console = new Systemlog();
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<String> Folders = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        Console.Log("Welcome to dir2list" + version);
        InputPath();
    }

    public static void InputPath() throws IOException {
        // Path
        Console.Log("Please enter the full Path:");
        Path = in.nextLine();

        // Filename
        Console.Log("Please enter the Filename:");
        Filename = "Output/" + in.nextLine() + ".txt";
        dir2file();

        Console.Log("(E)xit or (R)estart ? ");
        action = in.nextLine();
        CheckAction();

    }
    public static void dir2file() {
        try {

            FileWriter FolderWriter = new FileWriter(Filename);
            // File Header
            FolderWriter.write("dir2list Folders\n\n");

            // Folders to Arraylist
            Files.list(new File(Path).toPath())
                    .forEach(path -> {
                        Folders.add(path.toString());
                    });

            // Folder Array to String
            // Write Array to File
            for (String folder : Folders) {
                FolderWriter.write(folder + "\n");
            }

            // FileWrite Close
            FolderWriter.close();

            Console.Log("Successfully wrote to the file. \n" +
                            "Filename: " + Filename + " | Elements: " + Folders.size());
        } catch (IOException e) {
            Console.Log("An error occurred.");
            e.printStackTrace();
        }
    }

    // Check Input End or Restart
    public static void CheckAction() throws IOException {
        if(action.equals("E") || action.equals("e")){
            Console.Log("Exit Program");
            System.exit(0);
        }else if(action.equals("R") || action.equals("r")){
            Console.Log("Restart Program");
            InputPath();
        }

    }


}
