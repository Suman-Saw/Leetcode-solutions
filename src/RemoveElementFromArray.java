public class RemoveElementFromArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElementWithoutShift(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    private static int removeElementWithoutShift(int[] nums, int val) {
        int counter = 0;
        int length = nums.length;
        while (length > counter) {
            if (nums[counter] == val) {
                nums[counter] = nums[length-1];
                length--;
            }else {
                counter++;
            }
        }
        return length;
    }
}
