package validate;

import java.io.File;
import java.util.Scanner;

public class Validate {
    private static final Scanner scanner = new Scanner(System.in);

    public static File checkFileExist() {
        while (true) {
            System.out.print("Vui long nhap đuong dan thu muc cua tep: ");
            String path = scanner.nextLine().trim();
            if (path.isEmpty()) {
                System.out.println("DDuong dan khong đuoc đe trong. Vui long nhap lai.");
                continue;
            }
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Tep khong ton tai. Vui long nhap đuong dan hop le.");
                continue;
            }
            if (!file.isFile()) {
                System.out.println("Duonng dan khong phai la tep tin. Vui long nhap lai.");
                continue;
            }
            return file;
        }
    }
    
    public static String checkInputString() {
        while (true) {
            System.out.print("Vui long nhap chuoi can tim kiem:");
            String input = scanner.nextLine().trim();
            if (input.isBlank() || input == null) {
                System.out.println("Chuoi tim kiem khong đuoc đe trong. Vui long nhap lai.");
                continue;
            }
            return input;
        }
    }
}