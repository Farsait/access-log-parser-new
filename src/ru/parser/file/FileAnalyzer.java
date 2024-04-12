package ru.parser.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileAnalyzer {

    public static void analyzeFile(String path) {
        int countYB = 0;
        int countGB = 0;
        int countMozilla = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int fileLines = 0;
            while ((line = reader.readLine()) != null) {
                fileLines++;
                String[] words = line.split("\"");
                for (String word : words) {
                    if (word.contains("Googlebot"))
                        countGB++;
                    if (word.contains("YandexBot"))
                        countYB++;
                    if (word.contains("Mozilla"))
                        countMozilla++;
                }


                if (line.length() > maxLength) {
                    maxLength = line.length();
                }
                if (line.length() < minLength) {
                    minLength = line.length();
                }
            }
            System.out.println("YandexBot " + countYB);
            System.out.println("GoogleBot " + countGB);
            System.out.println("Общее колличество обращений к сайту: " + countMozilla);
            System.out.println("Самая длинная строка (Кол-во символов): " + maxLength);
            System.out.println("Самая короткая строка (Кол-во символов): " + minLength);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
