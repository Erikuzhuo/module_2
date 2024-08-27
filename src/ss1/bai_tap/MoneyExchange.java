package ss1.bai_tap;

import java.util.Scanner;

public class MoneyExchange {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập Số Tiền USD Cần Chuyển Đổi: ");
        usd= sc.nextDouble();
        double quyDoi=usd*vnd;
        System.out.println("Số Tiền VND Sau Quy Đổi: ");
        System.out.println(quyDoi+" VND");
    }
}
