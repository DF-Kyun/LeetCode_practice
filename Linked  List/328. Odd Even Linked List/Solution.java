/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 用两个链表分别连接奇数和偶数的结点，然后再把两个链表链接到一起
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode odd_start = new ListNode(0);
        ListNode odd_end = odd_start;
        ListNode even_start = new ListNode(0);
        ListNode even_end = even_start;
        ListNode plist = head;
        int n = 1;
        while(plist != null){
            if(n%2 == 1){
                odd_end.next = plist;
                odd_end = odd_end.next;
            }else{
                even_end.next = plist;
                even_end = even_end.next;
            }
            n++;
            plist = plist.next;
        }
        
        odd_start = odd_start.next;
        even_start = even_start.next;
        odd_end.next = even_start;
        even_end.next = null;
        
        return odd_start;
        
    }
}