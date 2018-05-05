class Solution:
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        numSet = set()
        while n != 1 and n not in numSet:
        	numSet.add(n)
        	n = sum([int(i)**2 for i in str(n)])
        return n == 1
