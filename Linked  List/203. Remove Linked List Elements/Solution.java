/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 设立虚拟头节点
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummynode = new ListNode(0);
        dummynode.next = head;
        ListNode cru = dummynode;
        
        while(cru.next != null){
            if(cru.next.val == val){
                ListNode delnode = cru.next;
                cru.next = delnode.next;
                delnode.next = null;
                
            }else{
                cru = cru.next;
            }
        }
        ListNode retnode = dummynode.next;
        dummynode.next = null;
        
        return retnode;

    }
}