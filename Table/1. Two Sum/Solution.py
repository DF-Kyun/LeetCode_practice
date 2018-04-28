class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        tempDict = dict()
        for i, element in enumerate(nums):
            if target - element in tempDict:
                return [tempDict[target - element], i]
            tempDict[element] = i