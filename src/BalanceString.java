public class BalanceString {
    public static void main(String[] args) {
        String str = "(ab)c))";
        System.out.println(getBalanceString(str));
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
}
