import java.util.Stack;

public class BalanceString {
    public static void main(String[] args) {
        String str = "(ab(()";
        System.out.println(getBalanceString(str));
        System.out.println(balanceStringUsingStack(str));
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
}
