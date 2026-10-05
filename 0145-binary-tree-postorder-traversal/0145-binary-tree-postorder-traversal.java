import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // LinkedList allows us to insert at the beginning in O(1) time
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            // Insert at the front to reverse the Root -> Right -> Left order
            result.addFirst(node.val); 
            
            // Push Left first so Right gets processed first (LIFO)
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        
        return result;
    }
}