package ss3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class CombineArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin Mời Nhập Số Phần Tử Mảng Thứ Nhất: ");
        int num1 = Integer.parseInt(scanner.nextLine());
        int[] numArray1 = new int[num1];
        for (int i = 0; i < num1; i++) {
            System.out.printf("Xin mời nhập giá trị phần tử %d: %n", i);
            numArray1[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("Mảng thứ nhất có %d giá trị: %n " + Arrays.toString(numArray1) + "%n", numArray1.length);

        System.out.println("Xin Mời Nhập Số Phần Tử Mảng Thứ Hai: ");
        int num2 = Integer.parseInt(scanner.nextLine());
        int[] numArray2 = new int[num2];
        for (int i = 0; i < num2; i++) {
            System.out.printf("Xin mời nhập giá trị phần tử %d: %n", i);
            numArray2[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("Mảng thứ hai có %d giá trị: %n " + Arrays.toString(numArray2) + "%n", numArray2.length);

        combineArrays(numArray1, numArray2);
    }

    public static void combineArrays(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                arr3[i] = arr2[i - arr1.length];
            }
        }
        System.out.printf("Mảng sau gọp có %d giá trị: %n " + Arrays.toString(arr3) + "%n", arr3.length);
    }
}
