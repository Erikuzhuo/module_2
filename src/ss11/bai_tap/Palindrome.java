package ss11.bai_tap;


import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        System.out.println(Arrays.toString(chars));
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
            queue.add(chars[i]);
        }


        boolean isPalindrome = true;
        for (int i = 0; i < chars.length; i++) {
            if(stack.pop() != queue.poll()) {
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome) {
            System.out.println("Entered string is a palindrome");
        } else {
            System.out.println("Entered string is not a palindrome");
        }
    }
}