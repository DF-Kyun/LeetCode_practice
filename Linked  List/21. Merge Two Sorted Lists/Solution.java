/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 建立虚拟头结点，之后对两个链表进行归并排序
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if(l1 != null){
            p.next = l1;
        }else{
            p.next = l2;
        }
        
        return head.next;
    }
}