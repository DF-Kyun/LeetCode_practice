class Solution:
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        sMap, tMap = dict(), dict()
        for i in range(len(s)):
        	sElement, tElement = sMap.get(s[i]), tMap.get(t[i])
        	if sElement is None and tElement is None:
        		sMap[s[i]], tMap[t[i]] = t[i], s[i]
        	elif sElement != t[i] or tElement != s[i]:
        		return False
        return True