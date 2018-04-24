package assignment7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cheaters {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<String>();

        File dir = new File("sm_doc_set"); // change this to args[0]
        String[] folder = dir.list();

        int lengthWord = 6; // change this to Integer.parseInt(args[1])

        for (String str: folder) {
            readFile();
        }

    }

    public static void readFile(File file, int lengthWord, ArrayList<String> words) throws FileNotFoundException{
        Scanner inFile = new Scanner(file);
        int index = 0;
        boolean bool = true;

        while (bool) {
            for (int j = 0; j < index; j++) {
                inFile.next();
            }

            for (int j = 0; j < lengthWord; j++) {
                StringBuilder s = new StringBuilder();

                if (inFile.hasNext() || inFile.hasNextLine()) {
                    String ah = inFile.next();
                    s.append(ah).append(" ");
                }
                words.add(s.toString());
            }

            if (inFile.hasNext()) {
                index++;
            } else {
                bool = false;
            }

            inFile.reset();
        } // while

        inFile.close();
    } // readfile

} // public class cheaters