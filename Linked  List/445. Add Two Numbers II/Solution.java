/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 1. 统计两链表长度s1, s2；最终结果链表长度s = max(s1, s2) （若有进位，则为s+1）
 2. 将两链表对齐并逐节点求和，记头节点为h（头节点为dummy node，最高位从h.next开始）
 3. 初始令指针p指向头节点h，执行循环：
    令指针q = p.next，重复向其下一节点移动，直到q为空或者q.val ≠ 9    
    如果q.val ＞ 9，说明p与q之间的所有节点需要进位，令p向q移动同时修改p.val
    否则，令p = q

 实际是利用两个指针实现进位。对于进位，当前位需要进位时，高1位如果不是就9，直接进1位就结束，
 如果是9，需要进位到依次的高1位不是9才停止，也就是只要知道需要进位的位前的第一个不为9的位，就知道了进位的范围了。
 piont1从头开始遍历，如果point1->val< 9令piont2 = point1
 如果point1>9，对point2到point1的节点加1，模10
 如果head大于10需要先生成一个节点。
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
        int s1 = getSize(l1);
        int s2 = getSize(l2);
        int s = Math.max(s1, s2);
        
        ListNode h = new ListNode(0);
        ListNode p = h;
        while(s != 0){
            p.next = new ListNode(0);
            p = p.next;
            if(s <= s1){
                p.val += l1.val;
                l1 = l1.next;
            }
            if(s <= s2){
                p.val +=l2.val;
                l2 = l2.next;
            }
            s--;
        }
        
        p = h;
        while(p != null){
            ListNode q = p.next;
            while(q != null && q.val == 9){
                q = q.next;
            }
            if(q != null && q.val > 9){
                while(q != p){
                    p.val += 1;
                    p = p.next;
                    p.val -=10;    
                }
            }else{
                p = q;
            }  
        }
        
        if(h.val != 0){
            return h;
        }else{
            return h.next;
        }
    }
    
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;      
    }
}