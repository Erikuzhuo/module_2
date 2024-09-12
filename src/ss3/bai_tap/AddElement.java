package ss3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin Mời Nhập Số Phần Tử Mảng Ban Đầu: ");
        int num = Integer.parseInt(scanner.nextLine());
        int[] numArray = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.printf("Xin mời nhập giá trị phần tử %d: %n",i);
            numArray[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.printf("Mảng ban đầu có %d giá trị: %n " + Arrays.toString(numArray)+"%n",numArray.length);

        System.out.println("Vị trí cần chèn: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Giá trị cần chèn: ");
        int value = Integer.parseInt(scanner.nextLine());

        addElement(numArray,index,value);
    }
    public static void addElement(int[] array, int index, int value){
        if(index>0 || index<array.length){
            int[] newArray = new int[array.length+1];
            for (int i = 0; i < newArray.length; i++) {
                if(i<index) {
                    newArray[i] = array[i];
                }else if(i==index){
                    newArray[i]=value;
                }else {
                    newArray[i]=array[i-1];
                }
            }
            System.out.printf("Mảng mới gồm %d phần tử: "+Arrays.toString(newArray),newArray.length);
        }else System.out.println("Xin mời nhập lại vị trí cần chèn");
    }
}


