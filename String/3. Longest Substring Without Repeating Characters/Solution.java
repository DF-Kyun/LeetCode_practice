/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 滑动窗口问题，[l, r] 表示目前的没有重复子串，r向前移动试探下一个字符是否重复，
 采用map存储当前子串中每个字符是否重复

*/


 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int length = 0;
        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
        while(l < s.length()){
            
            if(r+1<s.length() && (!map.containsKey(s.charAt(r+1)) || !map.get(s.charAt(r+1)))){
                
                map.put(s.charAt(++r), true);
            }else{
                map.put(s.charAt(l++), false);
            }
            
            length = Math.max(length, r-l+1);
        }
        
        return length;
        
    }
}