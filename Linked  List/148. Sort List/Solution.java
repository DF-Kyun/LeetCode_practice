/*
 时间复杂度 O(n*logn)
 空间复杂度 O(1) 

算法思想：利用归并排序对链表进行排序
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = slow.next;
        slow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        
        return mergeSort(left, right);     
    }
    
    public ListNode mergeSort(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        for(ListNode p=head;l1!=null || l2!=null;p=p.next){
            int val1 = (l1==null) ? Integer.MAX_VALUE : l1.val;
            int val2 = (l2==null) ? Integer.MAX_VALUE : l2.val;
            
            if(val1 < val2){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
        }
        return head.next;
    }
}