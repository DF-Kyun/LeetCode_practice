/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 算法思想：p与q之间的距离是n时，当p到达最后尾节点时，q就是要删除的倒数第n个节点，
 具体操作时，需要判断删除的是否是头结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        while(n-- > 0){
            p = p.next;
        }
        
        if(p == null){
            return head.next;
        }
        
        while(p.next != null){
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        
        return head;
    }
}