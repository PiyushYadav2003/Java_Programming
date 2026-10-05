/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either list is empty, there can't be an intersection
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        // Loop until both pointers reference the same node (or both hit null)
        while (ptrA != ptrB) {
            // If ptrA reaches the end of list A, redirect it to the head of list B
            ptrA = (ptrA == null) ? headB : ptrA.next;
            
            // If ptrB reaches the end of list B, redirect it to the head of list A
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        
        // Returns the intersected node, or null if they never intersected
        return ptrA;
    }
}