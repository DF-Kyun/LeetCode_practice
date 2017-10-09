/*
 时间复杂度 O(n^2)
 空间复杂度 O(1) 

 通过一个临时头结点记录排序的链表，记录head位置（未排序的头一个节点），
 遍历已排序的链表找到第一个大于未排序节点（未排序的第一个节点）的节点，
 插入排序链表，恢复head指针指向未排序的第一个节点
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
    public ListNode insertionSortList(ListNode head) {
        ListNode sortedhead = new ListNode(Integer.MIN_VALUE);
        
        while(head != null){
            //保存head位置
            ListNode temp = head.next;
            ListNode cru = sortedhead;
            while(cru.next != null && cru.next.val < head.val){
                
                cru = cru.next;
            }
            //插入
            head.next = cru.next;
            cru.next = head;
            
            //恢复head
            head = temp;
        }
        return sortedhead.next;
    }
}