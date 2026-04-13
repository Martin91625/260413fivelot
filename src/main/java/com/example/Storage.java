package com.example;

import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    
    public static void writeToFile(String line) {
        try {
            tryWriteToFile(line);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private static void tryWriteToFile(String line) throws IOException {
        FileWriter filewriter = new FileWriter("adat.txt", true);
        filewriter.write(line);
        filewriter.write("\n");
        filewriter.close();

    }

}
