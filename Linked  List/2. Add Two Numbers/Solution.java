/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 模拟加法，因为是反向存储，最后反向输出，所以可以模拟，注意进位操作

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count = 0;
        ListNode head = new ListNode(0);
        ListNode p3 = head;
        while(l1 != null || l2 != null){
            if(l1 != null){
                count += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                count += l2.val;
                l2 = l2.next;
            }
            p3.next = new ListNode(count%10);
            p3 = p3.next;
            count /= 10; 
        }
        if(count==1){
            p3.next = new ListNode(count);
            
        }
        
        return head.next;
    }
}