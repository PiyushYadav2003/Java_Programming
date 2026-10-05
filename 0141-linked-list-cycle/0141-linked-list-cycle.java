/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers, both starting at the head
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse the list until fast reaches the end (null)
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step at a time
            fast = fast.next.next;    // Moves 2 steps at a time
            
            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }
        
        // If the loop finishes, fast reached the end, meaning no cycle
        return false;
    }
}