/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 算法思想：把链表分成前半部分和后半部分，然后把后半部分反序，最后把后半部分依次插入前半部分。
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        
        fast = reverseList(fast);
        
        
        ListNode cru = head;
        ListNode next1;
        ListNode next2;
        while(fast != null){
            next1 = cru.next;
            cru.next = fast;
            next2 = fast.next;
            fast.next = next1;
            cru = next1;
            fast = next2;
        }
        
        
    }
    
    public ListNode reverseList(ListNode head) {
        
        ListNode pre = null;
        ListNode cru = head;
        while(cru != null){
            ListNode next = cru.next;
            
            cru.next = pre;
            pre = cru;
            cru = next;
        }
        
        return pre;
    }
}