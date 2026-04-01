import java.util.*;

public class StringAnagramProblem {
    public static void main(String[] args) {
        String[] strs = {"abc","xyz","pqr","bca","yzx","lmn"};
        findAnagram(strs);
    }

    private static void findAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String value : strs) {
            char[] c = value.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, v-> new ArrayList<>()).add(value);
        }
        map.forEach((k,v) -> System.out.println(k + " => " + v));
    }
}
