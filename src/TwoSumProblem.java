import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSuma(num, target)));
    }

    private static int[] twoSuma(int[] num, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //{2,7,11,15};
        for (int i = 0; i<num.length; i++) {
            int complement = target - num[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(num[i], i);//{2,0){7,1}
        }
        return new int[]{};
    }
}
