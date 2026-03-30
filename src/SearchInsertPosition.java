public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6,8};
        int target = 9;
        System.out.println(binarySearchInsert(nums, target));
    }

    private static int searchInsert(int[] nums, int target) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) {
                counter = i;
            }else if(target > nums[i]) {
                if (i+1 <= nums.length && target < nums[i + 1]) {
                    counter = i + 1;
                    break;
                }else if (i+1 == nums.length) {
                    counter = i + 1;
                }
            }
        }
        return counter;
    }

    private static int binarySearchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
