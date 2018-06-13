package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NewFile {
    private File base = new File("./Resources/base.txt");
    private File file = new File("./Resources/outputSplit.txt");
    private File fileReg = new File("./Resources/outputRegexp.txt");
    private FileReader fileReader;
    private FileWriter fileWriter;

    void split() {
        try {
            fileReader = new FileReader(base);
            fileWriter = new FileWriter(file);

            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) fileWriter.append(scanner.nextLine().split(", ")[1]).append("\n");

            scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void regexp() {
        try {
            fileReader = new FileReader(base);
            fileWriter = new FileWriter(fileReg);
            Scanner scanner = new Scanner(fileReader);
            String s = "\\S*@\\S*\\w";
            Pattern pattern = Pattern.compile(s);

            while (scanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(scanner.nextLine());
                if (matcher.find()) {
                    fileWriter.append(matcher.group()).append("\n");
                }
            }
            fileWriter.flush();

            scanner = new Scanner(new FileReader(fileReg));
            while (scanner.hasNextLine()) System.out.println(scanner.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
