package CaseStudy.ZooManagement.Pattern;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFormat {
    static Matcher matcher;
    static Pattern pattern;
    static String regex;
    public static boolean staffEmail(String email) {
        regex = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean animalID(String id) {
        regex = "^[EMOT][a-zA-Z0-9]{5}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean staffID(String id) {
        regex = "^Z[a-zA-Z0-9]{5}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean phoneNumber(String phoneNumber) {
        regex = "^09[0-9]{8}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean datePattern(String date) {
        regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
}
