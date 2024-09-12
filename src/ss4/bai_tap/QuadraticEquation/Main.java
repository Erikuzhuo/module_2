package ss4.bai_tap.QuadraticEquation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Phương trình bậc 2 có dạng ax^2+bx+c=0. Xin mời nhập tương ứng giá trị a,b,c: ");
        System.out.println("Giá trị a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Giá trị b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Giá trị c: ");
        double c = Double.parseDouble(scanner.nextLine());

        System.out.println("Phương trình có biểu thức: " + a + "x^2 + " + b + "x + " + c + " = 0.");

        QEClass Qe = new QEClass(a, b, c);
        double delta = Qe.getDiscriminant();
        double r1 = Qe.getRoot1();
        double r2 = Qe.getRoot2();
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình với vô số nghiệm");
            } else {
                System.out.println("Phương trình có nghiệm là: " + (-b / c));
            }
        } else {
            if (delta > 0) {
                System.out.println("Phương trình có hai nghiệm: " + r1 + " và " + r2 + ".");
            } else if (delta == 0) {
                System.out.println("Phương trình có một nghiệm: " + r1 + ".");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }
}