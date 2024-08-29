package ss2.bai_tap;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class DisplayArt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lựa Chọn Số Thứ Tự sau: \n" + "1. Print the rectangle\n" + "2. Print the square triangle\n" + "3. Print isosceles triangle\n" + "4. Exit");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case "2":
                for (int i = 0; i < 5; i++) {
                    for (int j = i; j < 5; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                System.out.println(" ");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println();
                }
                break;
            case "3":
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7 - i - 1; j++) {
                        System.out.print(" ");
                    }
                    for (int k = 0; k < i * 2 + 1; k++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Không Có Lựa Chọn");
                break;
        }
    }
}


