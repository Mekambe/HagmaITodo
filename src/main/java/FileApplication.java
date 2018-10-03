import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileApplication {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\RENT\\Desktop\\Git\\javapoz11-programowanie-kopiaszymona\\src\\main\\resources\\test.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}
