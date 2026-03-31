import com.sun.source.tree.Tree;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructBst(nums, 0 ,nums.length - 1);
    }

    private static TreeNode constructBst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBst(nums, left, mid - 1);
        root.right = constructBst(nums, mid + 1, right);

        return root;
    }
}

class TreeNode {
    int num;
    TreeNode left;
    TreeNode right;
    TreeNode(int num){
        this.num = num;
    }
}
