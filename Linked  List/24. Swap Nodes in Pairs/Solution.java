/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 建立虚拟头结点，之后按对交换节点，依次向后
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummynode = new ListNode(0);
        dummynode.next = head;
        
        ListNode p = dummynode;
        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            ListNode next = node2.next;
            
            p.next = node2;
            node2.next = node1;
            node1.next = next;
            p = node1;
            
        }
        
        return dummynode.next;
    }
}