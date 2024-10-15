package ss19.bai_tap.PhoneNumberVerification;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneVerification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        Pattern pattern;
        Matcher matcher;
        do {
            System.out.println("Input Phone Number: (09*-***-****)\n");
            phoneNumber = scanner.nextLine();;
            String regex = "^09\\d{1}[-\\s]?\\d{3}[-\\s]?\\d{4}$";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(phoneNumber);
        }while(!matcher.matches());
        System.out.println("Phone Number is: "+phoneNumber);
    }
}
