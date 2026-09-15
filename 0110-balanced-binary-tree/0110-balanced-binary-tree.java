/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the return value is -1, the tree is unbalanced.
        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        // Base case: an empty tree has a height of 0
        if (node == null) {
            return 0;
        }
        
        // Recursively check the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }
        
        // Recursively check the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }
        
        // Check if the current node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        // If it's balanced, return its true height
        return Math.max(leftHeight, rightHeight) + 1;
    }
}