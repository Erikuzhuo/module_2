package ss2.bai_tap;

import java.util.Scanner;

public class DisplayPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Xin Nhập Số Lượng Số Nguyên Tố Cần In: ");
        int number = sc.nextInt();
        int[] numbers = new int[number];
        int N = 3;
        int count = 1;
        numbers[0] = 2;
        boolean check = true;
        while (count < numbers.length) {
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
            if (check) {
                numbers[count] = N;
                count++;
            }
            N++;

        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Nguyên Tố " + (i + 1) + ": " + numbers[i]);
        }
    }
}

