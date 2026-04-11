import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestEvenNumber {
    public static void main(String[] args) {
        int[] num = {3,7,5,4,16,11,13,6,10};
        System.out.println(getSecondHighestEvenNumber(num));
        System.out.println(getSecondHighestEvenNumberUsingStream(num));
    }

    private static int getSecondHighestEvenNumber(int[] num) {
        int max = 0;
        int secondMax = 0;
        for (int val : num) {
            if (val%2 == 0) {
                if (val > max) {
                    secondMax = max;
                    max = val;
                }else if (max > val && secondMax < val){
                    secondMax = val;
                }
            }
        }
        return secondMax;
    }

    private static int getSecondHighestEvenNumberUsingStream(int[] num) {
        return Arrays.stream(num)
                .boxed()
                .filter(integer -> integer % 2 == 0)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
    }
}
