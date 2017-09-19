/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 算法思想：递归
 递归的精髓在于将p当做参数传入reverseList函数时，在下一次递归中对参数的操作，会反应在上次的参数值上，
 触底之后，把前一个节点的next置空，后一个节点的next指向前一个节点，返回最后一个节点（每次都是返回最后一个节点）。
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode p = head.next;
        ListNode n = reverseList(p);
        
        head.next = null;
        p.next = head;
        
        return n;
    }
}