package Tree;

import java.util.*;

public class TreeBuilderUsingQueue {
    public static void main(String[] args) {
        Integer[] numbers = {1,2,3};
        int[] sortedNumber = Arrays.stream(numbers)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        TreeNode root = buildTree(sortedNumber);
        insertIterative(root, 7);
        inorderIterative(root);
    }

    private static void iterateTreeNode(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val + " ");
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
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

    private static TreeNode buildTree(int[] numbers) {
        if (numbers == null || numbers.length == 0) return null;

        return buildValidBSTTree(numbers, 0 , numbers.length - 1);
    }

    private static TreeNode buildValidBSTTree(int[] sortedNumber, int left, int right) {
        if (left > right)return null;

        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(sortedNumber[mid]);
        root.left = buildValidBSTTree(sortedNumber, left, mid-1);
        root.right = buildValidBSTTree(sortedNumber, mid+1, right);

        return root;
    }

    public static TreeNode insertIterative(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) return newNode;

        TreeNode currentNode = root;
        TreeNode parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
            if (value < currentNode.val){
                currentNode = currentNode.left;
            }else {
                currentNode = currentNode.right;
            }
        }

        if (value < parentNode.val) {
            parentNode.left = newNode;
        }else {
            parentNode.right = newNode;
        }
        return root;
    }
}
