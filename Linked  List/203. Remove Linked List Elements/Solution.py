# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        cru = dummy
        while cru and cru.next:
        	if cru.next.val == val:
        		cru.next = cru.next.next
        	else:
        		cru = cru.next
        return dummy.next