package ss1.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner sc= new Scanner(System.in);
        System.out.println("Input a: ");
        float a = Float.parseFloat(String.valueOf(sc.nextFloat()));
        System.out.println("Input b: ");
        float b = Float.parseFloat(String.valueOf(sc.nextFloat()));
        System.out.println("Input c: ");
        float c = Float.parseFloat(String.valueOf(sc.nextFloat()));
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %.2f\n", answer);
        } else {
            if (b == c) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }
    }
}
