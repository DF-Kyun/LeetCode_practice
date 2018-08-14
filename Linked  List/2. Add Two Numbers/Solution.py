# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        count = 0
        head = ListNode(0)
        l3 = head
        while l1 or l2:
            if l1:
                count += l1.val
                l1 = l1.next
            if l2:
                count += l2.val
                l2 = l2.next
            l3.next = ListNode(count%10)
            l3 = l3.next
            count = count//10
        if count == 1:
            l3.next = ListNode(count)
        return head.next