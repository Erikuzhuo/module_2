package ss13.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ContinuouslyString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear();
            }

            list.add(string.charAt(i));

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        }


        for (Character ch: max) {
            System.out.print(ch);
        }
        System.out.println();
    }
}

/*Độ phức tạp của chương trình:
* vòng lặp ngoài đầu tiên duyệt qua n phần tử:O(n)
* vòng lặp trong trong trường hợp xấu nhất các ký tự được sếp từ lớn đến bé thì có n lần xóa và nhập phần tử: O(n)
* vòng lặp 2:O(n);
* T1(n) + T2(n)=O(Max(n^2,n) => O(n^2) */
