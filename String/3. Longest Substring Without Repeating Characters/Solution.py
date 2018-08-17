class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = 0
        r = -1
        length = 0
        map = {}
        while l < len(s):
            if r+1 < len(s) and (not(s[r+1] in map) or not(map.get(s[r+1]))):
                r += 1
                map[s[r]]=True
            else:
                map[s[l]]=False
                l += 1
            length = max(length,r-l+1)
        return length