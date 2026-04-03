import java.util.Arrays;

public class MergeTwoSorterArray {
    public static void main(String[] args) {
        int[] arr1 = {3,9,10,11,12};
        int[] arr2 = {5,6,7,8};
        System.out.println(Arrays.toString(mergeSortedArray(arr1, arr2)));
    }

    private static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }else {
                result[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            result[k++] = arr1[i++];
        }
        while (j < n2){
            result[k++] = arr2[j++];
        }
        return result;
    }
}
