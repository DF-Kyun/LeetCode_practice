/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 新建链表虚拟头结点dummynode，dummynode.next=head，并设置指针pre指针指向dummynode，
 cru指针指向pre.next（代表遍历指针）;当cru.next不为null，如果cru.next.val == cru.val，cru=cru.next；
 如果cru.next.val != cru.val；则需判断pre.next==cru？如果是，则pre=cru（继续向前进，判断下一位）；
 如果不是，则pre.next=cru.next（跳过重复的部分）
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
       if(head == null || head.next == null){
            return head;
       }

        ListNode dummynode = new ListNode(0);
        dummynode.next = head;
        ListNode pre = dummynode;
        ListNode cru = pre.next;
        
        while(cru.next != null){
            if(cru.next.val != cru.val){
                if(pre.next != cru){
                    pre.next = cru.next;
                }else{
                    pre = cru;
                }
            }
            cru = cru.next;

        }
        
        if(pre.next != cru){
            pre.next = cru.next;
        }
        
        return dummynode.next;
    }
}