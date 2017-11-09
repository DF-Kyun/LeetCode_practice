/*
 时间复杂度 O(nlogk)
 空间复杂度 O(k)

 算法思想：采用优先队列，java的优先队列采用heap实现，只需要将所有list head放进heap，每次取出顶部的一个链接到结果里，
 并将它的next放进heap（假如存在），直至heap为空也就是所有元素都访问过一遍。
 其中存取元素以及链接的复杂度都是O(1)，而heap存入新元素的复杂度是O(log(k))，于是整个算法的复杂度就是O(log(k) * n)，n为所有list里元素的个数之和。
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        int size = lists.length;
        if(size == 0){
            return null;
        }
        if(size == 1){
            return lists[0];
        }
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(2,
            new Comparator<ListNode>(){
                public int compare(ListNode node1, ListNode node2){
                    return node1.val - node2.val;
                }        
            }
        );
        
        for(ListNode node : lists){
            if(node != null){
                heap.add(node);
            }
        }
        
        ListNode head = null;
        ListNode cru = null;
        ListNode heapNode = null;
        while(!heap.isEmpty()){
            heapNode = heap.poll();
            
            if(heapNode.next != null){
                heap.add(heapNode.next);
            }
            
            if(head == null){
                head = heapNode;
                cru = heapNode;
            }else{
                cru.next = heapNode;
                cru = cru.next;
            }
        }
        
        return head;
    }
}