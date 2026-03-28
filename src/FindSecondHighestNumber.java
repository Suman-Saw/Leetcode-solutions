public class FindSecondHighestNumber {
    public static void main(String[] args) {
        int[] arr = {2,6,1,11,14,7,9,13,20};
        System.out.println(findSecondHighestNumber(arr));
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
}
