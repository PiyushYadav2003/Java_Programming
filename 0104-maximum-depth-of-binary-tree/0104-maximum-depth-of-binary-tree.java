class Solution {
    public int maxDepth(TreeNode root) {

        // Empty tree
        if (root == null) {
            return 0;
        }

        // Find depth of left and right subtree
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the greater depth + current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}