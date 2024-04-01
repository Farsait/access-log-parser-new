import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        int count = 0;
        int totalLines = 0;
        int maxLength = Integer.MIN_VALUE;
        int minLength = Integer.MAX_VALUE;
        while (count >= 0) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExists == isDirectory) {
                System.out.println("Не существует/файл не верный");
            }
            else {
                System.out.println("Верный путь!");
                count++;
                System.out.println("Файл номер: " + count);
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;
                    int fileLines = 0;
                    int maxLineLength = 0;
                    int minLineLength = Integer.MAX_VALUE;

                    while ((line = reader.readLine()) != null) {
                        fileLines++;
                        if (line.length() > maxLineLength) {
                            maxLineLength = line.length();
                        }
                        if (line.length() < minLineLength) {
                            minLineLength = line.length();
                        }
                    }
                    totalLines += fileLines;
                    System.out.println("Количество строк в файле: " + fileLines);

                    if (maxLineLength > maxLength) {
                        maxLength = maxLineLength;
                    }
                    if (minLineLength < minLength) {
                        minLength = minLineLength;
                    }
                    reader.close();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (maxLength > 1024) {throw new RuntimeException("Есть строка длиннее 1024 символов");}
            }
            System.out.println("Самая длинная строка (Кол-во символов): " + maxLength);
            System.out.println("Самая короткая строка (Кол-во символов): " + minLength);
        }
    }
}
