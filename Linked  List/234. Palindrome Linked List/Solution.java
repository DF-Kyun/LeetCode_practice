/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

算法思想：1.使用快慢指针寻找链表中点
2.将链表的后半部分就地逆置（逆置的过程中判断是奇数个节点还是偶数个节点），然后比对前后两半的元素是否一致

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){
            slow.next = reverseList(slow.next);
            slow = slow.next;
        }else{
            slow = reverseList(slow);
        }
        
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
     
        return true;
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