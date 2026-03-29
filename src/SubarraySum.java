import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args) {
        int[] numbs = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 6;
        System.out.println("Total subarrays: " + countSubarrays(numbs, k));
    }

    public static int countSubarrays(int[] numbs, int k) {
        int count = 0;
        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : numbs) {//{3, 4, 7, 2, -3, 1, 4, 2};
            runningSum = runningSum + num;
            if (map.containsKey(runningSum - k)) {
                count +=map.get(runningSum - k);
            }
            map.put(runningSum, map.getOrDefault(runningSum,0) + 1);
        }
        return count;
    }
}
