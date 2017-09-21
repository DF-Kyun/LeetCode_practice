/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 解法思想：获取第一个值，然后依次向后遍历，到第一个不同的值之后，
 舍弃之间的节点，将第一个值next指向不同值，依次向后

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        int nodeval = head.val;
        ListNode first = head;
        ListNode pre = head;
        ListNode cru = head.next;
        while(cru != null){
            if(nodeval == cru.val){
                pre = cru;
                cru = cru.next;
            }else{
                pre.next = null;
                first.next = cru;
                first = cru;
                pre = cru;
                nodeval = first.val;
                cru = first.next;
            }
        }
        
        first.next = cru;
        
        return head;
    }
}