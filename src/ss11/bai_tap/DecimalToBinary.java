package ss11.bai_tap;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int decimal = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal/2;
        }
        int stackSize = stack.size();
        System.out.print("The binary number is: ");
        for (int i = 0; i < stackSize; i++) {
            System.out.print(stack.pop());
        }
    }
}