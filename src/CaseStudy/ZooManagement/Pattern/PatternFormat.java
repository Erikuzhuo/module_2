package CaseStudy.ZooManagement.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFormat {
    public static boolean animalIDPattern(String id){
        Matcher matcher;
        do{
            String regex = "^[a-zA-Z0-9_.±]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
            Pattern pattern = new Pattern()
        }while(matcher.matches());
    }
}
