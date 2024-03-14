import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        while (count >= 0) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (fileExists == isDirectory) {
                System.out.println("Не существует/файл не верный");
                } else {
                System.out.println("Верный путь!");
                count++;
                System.out.println("Файл номер: " + count);
            }
        }
    }
}
