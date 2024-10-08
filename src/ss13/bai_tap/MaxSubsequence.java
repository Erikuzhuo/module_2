package ss13.bai_tap;

import java.util.*;

public class MaxSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
                list.clear();
            }
        }
        for (Character ch : max) {
            System.out.print(ch);
        }
    }
}
//* Độ phức tạp của chương trình:
//*** Phức tạp thời gian:
//* chương trình có 2 vòng lặp:
//* vòng lặp 1:
//* Vòng lặp ngoài: Thêm vào list n phần tử, độ phức tạp: O(n);
//* Vòng lặp trong: Xét ký tự tiếp theo thêm vào list, độ phức tạp: O(n-1);
//* Các câu lệnh khác có độ phức tạp là O(1), việc thêm vào max tối đa cũng là O(n)
//* Tổng độ phức tạp vòng lặp 1: T1(n) = O(n*(n-1)+n) = O(n^2 - n + n ) => O(n^2) => hai vòng lặp hoàn thành mới đến câu
//* câu lệnh thêm.
//* Vòng lặp 2:
//* Tối đa O(n) vòng => T2 = O(n)
//* Độ phức tạp thời gian chương trình = T(n) = T1 + T2 = O(Max(n^2,n))=> O(n^2)
//
//* Độ phức tạp không gian:
//* Kết quả cuối cùng trong trường hợp lý tưởng nhất tất cả các ký tự được lưu thì độ phức tạp không gian O(n) */
