package ss3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Số Lượng Phần Tử Mảng:　");
        int length = Integer.parseInt(scanner.nextLine());
        int[] ArrNumbers = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Phần Tử %d:%n", i);
            ArrNumbers[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng Vừa Nhập: ");
        System.out.println(Arrays.toString(ArrNumbers));

        System.out.println("Phần tử cần xóa:　");
        int check = Integer.parseInt(scanner.nextLine());

        deleteElement(ArrNumbers,check);
    }
    public static void deleteElement(int[] arr, int num){
        boolean check = false;
        for (int arrNumber : arr) {
            if (arrNumber == num) {
                check = true;
                break;
            }
        }

        if (check) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == num) {
                    for (int j = i; j < arr.length-1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = 0;
                    i--;
                }
            }
            System.out.println("Mảng mới có giá trị: ");
            System.out.println(Arrays.toString(arr));
        }else System.out.println("Không có phần tử cần xóa.");
    }
}
