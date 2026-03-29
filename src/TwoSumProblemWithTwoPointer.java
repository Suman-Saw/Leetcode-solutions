import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblemWithTwoPointer {
    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        int target = 13;
        System.out.println(Arrays.toString(twoSums(num, target)));
    }

    private static int[] twoSums(int[] num, int target) {
        int left = 0, right = num.length-1;
        Arrays.sort(num);
        while (left < right) {
            int total = num[left] + num[right];
            if (total == target) {
                return new int[]{left, right};
            }else if (total < target) {
                left++;
            }else {
                right--;
            }
        }
        return new int[]{};
    }
}
