public class FindLongestRepeatSubStr {
    public static void main(String[] args) {
        String str = "da2kr32a2";
        System.out.println(SearchingChallenge(str));
    }

    private static String SearchingChallenge(String str) {
        int n = str.length();
        String longestSubString = "";
        for (int len = n/2; len >= 2; len--) {
            for (int i = 0; i < n-len; i++) {
                String sub = str.substring(i, i+len);
                if (str.indexOf(sub) != str.lastIndexOf(sub)) {
                    longestSubString = sub;
                    return "yes " + longestSubString;
                 }
            }
        }
        return "no null";
    }
}
