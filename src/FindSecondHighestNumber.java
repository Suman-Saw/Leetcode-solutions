import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        int[] arr = {2,6,1,11,14,7,9,13};
        System.out.println(findSecondHighestNumber(arr));
        System.out.println(findSecondHighestNumberUsingPriorityQueue(arr));
        System.out.println(findSecondHighestNumberUsingStream(arr));
    }

    private static int findSecondHighestNumber(int[] arr) {
        if (arr.length <= 1) {
            return arr[0];
        }
        int max = 0;
        int secondMax = 0;
        for (int x : arr) {
            if (x > max) {
                secondMax = max;
                max = x;
            }else if (max > x && x > secondMax) {
                secondMax = x;
            }
        }
        return secondMax;
    }
    private static int findSecondHighestNumberUsingPriorityQueue(int[] arr) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int x : arr) {
            if (!priorityQueue.contains(x)) {
                priorityQueue.add(x);
                if (priorityQueue.size() > 2) {
                    priorityQueue.poll();
                }
            }
        }
        return priorityQueue.peek();
    }

    private static int findSecondHighestNumberUsingStream(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
    }
}
