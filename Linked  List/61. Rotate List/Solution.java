/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 算法思想：先遍历一遍，得出链表长度 count，注意 k 可能大于 count，因此令 k% = count。将尾节点 next 指针
 指向首节点，形成一个环，接着往后跑 count -  k 步，从这里断开。
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode pre = head;
        int count = 1;
        while(pre.next != null){
            pre = pre.next;
            count++;
        }
        pre.next = head;
        k %= count;
        
        pre = pre.next;
        ListNode cru = head;
        int index = count-k;
        while(index > 0){
            pre = cru;
            cru = cru.next;
            index--;
        }
        pre.next = null;
        head = cru;
        
        return head;
    }
}