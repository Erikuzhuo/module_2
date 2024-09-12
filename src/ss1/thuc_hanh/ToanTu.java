package ss1.thuc_hanh;

import java.util.Scanner;

public class ToanTu {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập Width: ");
        width=sc.nextFloat();
        System.out.println("Nhập Height: ");
        height=sc.nextFloat();

        float area = width * height;
        System.out.println("Diện tích: ");
        System.out.println(Math.round(area*100)/100);
    }
}
