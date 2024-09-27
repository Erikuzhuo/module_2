package ss1.thuc_hanh;

import java.util.Scanner;

public class ReadNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc (0-999): ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("Out of ability");
        } else {
            System.out.println(numberToWords(number));
        }
    }

    public static String numberToWords(int number) {
        if (number < 10) {
            return getSingleDigitName(number);
        } else if (number < 20) {
            return getTeensName(number);
        } else if (number < 100) {
            return getTensName(number / 10) + (number % 10 != 0 ? " " + getSingleDigitName(number % 10) : "");
        } else {
            return getSingleDigitName(number / 100) + " hundred"
                    + (number % 100 != 0 ? " and " + numberToWords(number % 100) : "");
        }
    }

    public static String getSingleDigitName(int number) {
        switch (number) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    public static String getTeensName(int number) {
        switch (number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    public static String getTensName(int number) {
        switch (number) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";
        }
    }
}