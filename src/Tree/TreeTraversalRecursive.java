package Tree;

public class TreeTraversalRecursive {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        printInorderTree(root); //Left -> root -> right
        System.out.println("===========================");
        printOrderTree(root); //root -> left -> right
        System.out.println("===========================");
        printPostOrderTree(root); // left -> right -> root
    }

    private static void printPostOrderTree(TreeNode root) {
        if (root == null) return;
        printPostOrderTree(root.left);
        printPostOrderTree(root.right);
        System.out.println(root.val + " ");
    }

    private static void printOrderTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val + " ");
        printOrderTree(root.left);
        printOrderTree(root.right);
    }

    private static void printInorderTree(TreeNode root) {
        if (root == null) return;
        printInorderTree(root.left);
        System.out.println(root.val + " ");
        printInorderTree(root.right);
    }


    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructTree(nums, 0, nums.length-1);
    }

    private static TreeNode constructTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums,left,mid-1);
        root.right = constructTree(nums, mid+1, right);

        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
