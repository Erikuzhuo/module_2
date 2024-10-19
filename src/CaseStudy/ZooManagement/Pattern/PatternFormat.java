package CaseStudy.ZooManagement.Pattern;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFormat {
    public static boolean staffEmail(String email){
        Matcher matcher;
        do{
            String regex = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(email);
        }while(!matcher.matches());
        return matcher.matches();
    }

    public static boolean animalID(String id){
        Matcher matcher;
        do{
            String regex = "^[EMOT]+[a-zA-Z0-9]{5}+$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(id);
        }while(!matcher.matches());
        return matcher.matches();
    }

    public static boolean staffID(String id){
        Matcher matcher;
        do{
            String regex = "^Z+[a-zA-Z0-9]{5}+$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(id);
        }while(!matcher.matches());
        return matcher.matches();
    }

    public static boolean phoneNumber(String phoneNumber){
        Matcher matcher;
        do{
            String regex = "^09+[0-9]{8}+$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(phoneNumber);
        }while(!matcher.matches());
        return matcher.matches();
    }

    public static boolean datePattern(String date){
        Matcher matcher;
        do{
            String regex = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
            Pattern pattern = Pattern.compile(regex);
            matcher = pattern.matcher(date);
        }while(!matcher.matches());
        return matcher.matches();
    }
}
