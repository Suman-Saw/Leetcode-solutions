package Tree;

import java.util.Arrays;

public class FindValidBSTTree {
    public static void main(String[] args) {
        int[] arr = {1,7,3,9};
        TreeNode root = buildBSTTree(Arrays.stream(arr)
                .sorted()
                .toArray());
        System.out.println(findValidBstTree(root));
    }

    private static boolean findValidBstTree(TreeNode root) {
        return validateTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateTree(TreeNode root, long minValue, long maxValue) {
        if (root == null)return true;

        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }

        return validateTree(root.left, minValue, root.val) && validateTree(root.right, root.val, maxValue);
    }

    private static TreeNode buildBSTTree(int[] array) {
        if (array == null || array.length == 0)return null;
        return buildValidBstTree(array, 0, array.length-1);
    }

    private static TreeNode buildValidBstTree(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = buildValidBstTree(array, left, mid-1);
        root.right = buildValidBstTree(array, mid+1, right);
        return root;
    }
}
