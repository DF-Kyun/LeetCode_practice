/*
 时间复杂度 O(1)
 空间复杂度 O(1) 

 将后一个节点的值赋值给当前节点，删除后一个节点，条件中给出不会删除尾节点，所以不需要考虑node.next为空的情况
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
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}