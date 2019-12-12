'''
    时间复杂度 O(n)
    空间复杂度O(n)

    利用数组模拟栈解决
'''
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
            def toString(S):
                ans = []
                for c in S:
                    if c == "#":
                        ans and ans.pop()
                    else:
                        ans.append(c)
                return ''.join(ans)
            return toString(S) == toString(T)