/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 遍历节点信息，每K个为一组，利用尾插法反转（每次反转多传入一个节点），相邻两组之间连接
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        for(int i=0;i<k;i++){
            if(node == null){
                return head;
            }
            node = node.next;
        }
        ListNode new_head = reverse(head, node);
        head.next = reverseKGroup(node, k);
        return new_head;
    }
    
    public ListNode reverse(ListNode start, ListNode end){
        ListNode phead = end;
        
        while(start != end){
            ListNode temp = start.next;
            start.next = phead;
            phead = start;
            start = temp;
        }
        return phead;
    }
}