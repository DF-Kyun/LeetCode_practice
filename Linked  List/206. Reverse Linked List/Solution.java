/*
 时间复杂度 O(n)
 空间复杂度 O(1) 

 算法思想：迭代
 按顺序对指针指向的扭转，pre为当前节点的前一个节点，cru为当前节点，
 当前界节点不为空时，next指向下一个节点，
 开始更改指向，当前节点的next向前指向前一个节点，
 更改pre与cru指向的节点，依次向后一个。
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
    public ListNode reverseList(ListNode head) {
        
        ListNode pre = null;
        ListNode cru = head;
        while(cru != null){
            ListNode next = cru.next;
            
            cru.next = pre;
            pre = cru;
            cru = next;
        }
        
        return pre;
    }
}