/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 算法思想：遍历到要反转的第一个节点，翻转子串，然后拼接到原来的链表上
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        if(m == n){
            return head;
        }
        ListNode pre = null;
        ListNode cru = head;
        for(int i=0;i<m-1;i++){
            pre = cru;
            cru = cru.next;
        }
        
        ListNode chend = cru;
        ListNode chpre = cru;
        cru = cru.next;
        for(int j=m+1;j<=n;j++){
            ListNode chnext = cru.next;
            
            cru.next = chpre;
            chpre = cru;
            cru = chnext;
        }
        
        chend.next = cru;
        
        if(pre != null){
            pre.next = chpre;
        }else{
            head = chpre;
        }
        
        return head;
    }
}