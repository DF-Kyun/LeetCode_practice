# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        pre = ListNode(0)
        cru = head
        while cru:
        	next = cru.next
        	cru.next = pre.next
        	pre.next = cru
        	cru = next
        return pre.next
