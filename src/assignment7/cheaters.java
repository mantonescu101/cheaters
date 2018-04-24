package assignment7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cheaters {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<String>();

        File dir = new File("sm_doc_set"); // change this to args[0]
        File[] folder = dir.listFiles();

        int lengthWord = 6; // change this to Integer.parseInt(args[1])

        File[] folder1 = new File[1];
        folder1[0] = folder[0];
        for (File f: folder1) {
            BufferedReader inFile = new BufferedReader(new FileReader(f));

            int index = 0;
            boolean bool = true;

            System.out.println(f.getName());

            while (bool) {
                StringBuilder s = new StringBuilder();

                for (index = 0; index < lengthWord;) {
                    if(index == 1)
                        inFile.mark(lengthWord*10);

                    if (inFile.ready()) {
                        char c = (char)inFile.read();

                        if(c == ' ')
                            index++;
                        else{
                            if(c >= 'A' && c <= 'Z')
                                s.append((char)(c - 'A' + 'a'));
//                            else if(c > 'a' && c < 'z')
//                                s.append((char)c - 'a' + 'A');
                            else
                                s.append(c);
                        }
                    }
                }

                words.add(s.toString());

                if (inFile.read() == -1)
                    bool = false;

                inFile.reset();

            } // while

            inFile.close();
        }

        for(String s : words)
            System.out.println(s);

    }

//    public static void readFile(File file, int lengthWord, ArrayList<String> words) throws FileNotFoundException{
//        Scanner inFile = new Scanner(file);
//        int index = 0;
//        boolean bool = true;
//
//        while (bool) {
//            for (int j = 0; j < index; j++) {
//                inFile.next();
//            }
//
//            for (int j = 0; j < lengthWord; j++) {
//                StringBuilder s = new StringBuilder();
//
//                if (inFile.hasNext() || inFile.hasNextLine()) {
//                    String ah = inFile.next();
//                    s.append(ah).append(" ");
//                }
//                words.add(s.toString());
//            }
//
//            if (inFile.hasNext()) {
//                index++;
//            } else {
//                bool = false;
//            }
//
//            inFile.reset();
//        } // while
//
//        inFile.close();
//    } // readfile

} // public class cheaters