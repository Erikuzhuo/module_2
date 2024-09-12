package ss3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin mời nhập số lượng mảng con: ");
        int subArray = Integer.parseInt(scanner.nextLine());
        System.out.println("Xin mời nhập số lượng phần tử trong mảng con: ");
        int subEle = Integer.parseInt(scanner.nextLine());
        int[][] ArraysResult = new int[subArray][subEle];
        for (int i = 0; i < subArray; i++) {
            for (int j = 0; j < subEle; j++) {
                System.out.println("Xin mời nhập giá trị phần tử "+j+" trong mảng con "+i+": ");
                ArraysResult[i][j] = Integer.parseInt(scanner.nextLine());
            }
        } System.out.printf("Mảng có giá trị: %s%n", Arrays.deepToString(ArraysResult));

        minSubArrayValue(ArraysResult);
    }
    public static void minSubArrayValue(int[][] arr){
        int min = arr[0][0];
        for (int[] x:arr) {
            for(int k:x){
                if(k<min){
                    min=k;
                }
            }
        }
        System.out.printf("Giá trị nhỏ nhất là: %d",min);
    }
}
