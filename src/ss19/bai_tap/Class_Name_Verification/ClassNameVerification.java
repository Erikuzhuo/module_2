package ss19.bai_tap.Class_Name_Verification;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassNameVerification {
    public static void main(String[] args) {
        Matcher matcher;
        String className;
        do {
                Scanner scanner = new Scanner(System.in);
            String regex = "[ACP][0-9]{4}[G-K]";
            System.out.println("Input Class Name: ");
            className = new String(scanner.nextLine());
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(className);
        } while (!matcher.matches());
        System.out.println("Class "+className +" already created.");

    }
}
