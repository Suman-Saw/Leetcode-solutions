import java.sql.SQLOutput;
import java.util.*;

public class BalanceString {
    public static void main(String[] args) {
        String str = "(ab(()";
        System.out.println(getBalanceString(str));
        System.out.println(balanceStringUsingStack(str));
        System.out.println(balanceStringUsingArrayQueue(str));
    }

    private static String getBalanceString(String str) {
        int open = 0;
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++;
            }else if (c == ')'){
                if (open == 0) continue;
                open--;
            }
            result.append(c);
        }
        StringBuilder finalResult =  new StringBuilder();
        int close = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);
            if (c == ')') {
                close++;
            }else if (c == '(') {
                if (close == 0) continue;
                close--;
            }
            finalResult.append(c);
        }
        return finalResult.reverse().toString();
    }
    private static String balanceStringUsingStack(String str) {
        StringBuilder result = new StringBuilder(str);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }else {
                    result.setCharAt(i, '\0');
                }
            }
        }
        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(),'\0');
        }

        return result.toString().replace("\0", "");
    }
    public static String balanceStringUsingArrayQueue(String str) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> indexToRemove = new HashSet<>();
        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                }else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!indexToRemove.contains(i)) {
                finalResult.append(str.charAt(i));
            }
        }
        return finalResult.toString();
    }
}
