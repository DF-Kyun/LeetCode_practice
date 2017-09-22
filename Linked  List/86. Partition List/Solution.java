/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 用两个链表分别连接小于和大于等于x 的结点，然后再把两个链表链接到一起
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode little_start = new ListNode(0);
        ListNode little_end = little_start;
        ListNode big_start = new ListNode(0);
        ListNode big_end = big_start;
        ListNode plist = head;
        while(plist != null){
            if(plist.val < x){
                little_end.next = plist;
                little_end = little_end.next;
            }else{
                big_end.next = plist;
                big_end = big_end.next;
            }
            plist = plist.next;
        }
        
        little_start = little_start.next;
        big_start = big_start.next;
        
        if(little_start != null){
            
            little_end.next = big_start;
            if(big_end != null){
                big_end.next = null;
            }
        }else{
            little_start = big_start;
        }
        return little_start;
    }
}