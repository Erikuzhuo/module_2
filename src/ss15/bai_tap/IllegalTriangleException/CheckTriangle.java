package ss15.bai_tap.IllegalTriangleException;

import java.util.Scanner;

public class CheckTriangle {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Kindly input Triangle size a;b;c: ");
            String temp = scanner.nextLine().trim();
            String[] stringTriangle = temp.split(";");
            double a = Double.parseDouble(stringTriangle[0]);
            double b = Double.parseDouble(stringTriangle[1]);
            double c = Double.parseDouble(stringTriangle[2]);
            checkTriangle(a, b, c);
            System.out.println("Done.");
        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi không hợp lệ: " + e.getMessage());
        }
    }

    public static void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalTriangleException("Các cạnh của tam giác phải lớn hơn 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Tổng hai cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
