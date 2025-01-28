package com.rafi.practice;

import java.nio.file.Path;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        this.val = value;
        left = right = null;
    }
}

public class BinaryTree {

    public static TreeNode createTree() {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    // Preorder Traversal (Root -> Left -> Right)
    public static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Inorder Traversal (Left -> Root -> Right)
    public static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    // Postorder Traversal (Left -> Right -> Root)
    public static void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }
    
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static String serialize(TreeNode root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }
    
    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(nodes);
    }

    private static TreeNode helper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = helper(nodes);
        root.right = helper(nodes);
        return root;
    }
    
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    // Main method
    public static void main(String[] args) {
        // Create the tree
        TreeNode root = createTree();
        TreeNode root2 = createTree();

        // Perform traversals
        System.out.println("Preorder Traversal:");
        preorderTraversal(root);
        System.out.println();

        System.out.println("Inorder Traversal:");
        inorderTraversal(root);
        System.out.println();

        System.out.println("Postorder Traversal:");
        postorderTraversal(root);
        System.out.println();
        
        System.out.println("Max Depth:");
        int max = maxDepth(root);
        System.out.println(max);
        
        System.out.println("identical trees: ");
        boolean check = isSameTree(root, root2);
        System.out.println(check);
        
        System.out.println("is balanced tree:");
        boolean check2 = isBalanced(root);
        System.out.println(check2);
        
        System.out.println("Serialized:");
        String str = serialize(root);
        System.out.println(str);
        
        System.out.println("has Path Sum 10:");
        boolean check3 = hasPathSum(root,10);
        System.out.println(check3);
    }
}