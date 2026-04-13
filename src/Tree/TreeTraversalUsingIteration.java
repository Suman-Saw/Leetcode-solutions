package Tree;

import java.util.Stack;

public class TreeTraversalUsingIteration {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        TreeNode root = createBST(numbers);

        preOrderTraversal(root);
        System.out.println("=====================");
        inorderIterative(root);
        System.out.println("=====================");
        postOrderIterative(root);
    }

    private static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void inorderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.println(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }

    public static void postOrderIterative(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        TreeNode lastVisited = null;

        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    currentNode = peekNode.right;
                }else {
                    System.out.println(peekNode.val + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }

    private static TreeNode createBST(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;
        return createBSTTree(numbers, 0, numbers.length-1);
    }

    private static TreeNode createBSTTree(int[] numbers, int left, int right) {
        if (left > right){
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(numbers[mid]);
        root.left = createBSTTree(numbers, left, mid-1);
        root.right = createBSTTree(numbers, mid+1, right);

        return root;
    }
}

