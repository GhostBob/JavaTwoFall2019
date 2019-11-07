package scannerrocks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerRocks {

    public static void main(String[] args) {
        doFilesStuff();
    }

    public static void doStudentStuff() {
        Path filePath = Paths.get("students.txt");
        List<Integer> grades = new ArrayList();
        grades.add(100);
        grades.add(99);
        grades.add(98);
        Student student = new Student(123, "Robert", "Paulson", grades);
        try {
            FileOutputStream f = new FileOutputStream(new File("myFreezeDriedStudent.srlz"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(student);
            o.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        student = null;
        System.out.println("Before deserialization: " + student + "\n\n");
        try {
            FileInputStream f = new FileInputStream(new File("myFreezeDriedStudent.srlz"));
            ObjectInputStream o = new ObjectInputStream(f);
            Object obj = o.readObject();
            o.close();
            if (obj instanceof Student) {
                student = (Student) obj;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        System.out.println("After deserialization: ");
        System.out.println(student);
    }

    public static void doFilesStuff() {
        Path filePath = Paths.get("new-file.txt");
        List<String> lines = new ArrayList();
        lines.add("Hello, world!");
        //Writing a List of Strings to a file.
        try {
            //Comment this and uncomment the other if you want to APPEND.
            Files.write(filePath, lines, Charset.forName("UTF-8"));
            //Uncomment this to APPEND instead of OVERWRITE
//            Files.write(filePath, lines, Charset.forName("UTF-8"), 
//                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e);
        }

        //Reading from a file
        try {
            List<String> readLines = Files.readAllLines(filePath);
            for (String line : readLines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //Old and busted way of doing file access.
    public static void doBufferedStuff() {
        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("help-me.txt"),
                        "UTF-8"))) {
            writer.write("Help yourself!\n");
            writer.write("More stuff\n");
            writer.flush();
            writer.write("\n\n\n\n");
            writer.write("Four score and seven years ago\n");
            writer.write("Our forefathers set forth on this continent a new nation");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // writer.close(); //This is a good place to put something like this,
            //                  if it weren't already managed for you.
        }

        try (BufferedReader reader = new BufferedReader(
                new FileReader("help-me.txt"))) {
            int counter = 0;
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                counter++;
                System.out.println(counter + ": " + currentLine);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void doFormatStuff() {
        String s = String.format("Hello %s", "world!");
        System.out.println(s);
        System.out.printf("Hello %s\n", "world!");
        String header = String.format("%10s %10s %10s", "Col1", "Col2", "Col3");
        String data = String.format("%10d %10d %10d", 1, 2, 3);
        System.out.println(header);
        System.out.println(data);
    }

    public static void doStringStuff() {
        String s = "";
        for (int i = 0; i < 100000; ++i) {
            s += (i + "\n");
        }
        System.out.println(s);
    }

    public static void doStringBuilderStuff() {
        StringBuilder s = new StringBuilder(100000); // A suggested capacity.
        for (int i = 0; i < 100000; ++i) {
            s.append(i); //Append instead of +
            s.append("\n");
        }
        String realString = s.toString();
        System.out.println(realString);
    }

    public static void doScannerStuff() {
        Scanner scanner = new Scanner(System.in);
        Integer magicNumber = null;
        while (magicNumber == null) {
            System.out.print("Enter an integer: ");
            String input = scanner.nextLine();
//            int input = scanner.nextInt(); //Kinda sorta inconvenient in the long run.
            try {
                magicNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("I said an INTEGER. For shame...");
            }
        }

        System.out.println("The magic number you gave me is: " + magicNumber);
    }
}
