import java.util.HashMap;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(findLongestCommonPrefix(str));
    }

    private static String findLongestCommonPrefix(String[] str) {
       String prefix = str[0];
       for (int i = 1; i < str.length; i++) {
           while (str[i].indexOf(prefix) != 0){
               prefix = prefix.substring(0, prefix.length()-1);
               if (prefix.isEmpty())
                   break;
           }
       }
       return prefix;
    }
}

