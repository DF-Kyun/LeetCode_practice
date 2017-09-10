/*
 时间复杂度 O(n)
 空间复杂度 O(n) 


 利用Map记录两个字符串中字符出现的次数，最后比较是否相等

*/


class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        Map<Character, Integer> mapt = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++){
            if(!maps.containsKey(s.charAt(i))){
                maps.put(s.charAt(i), 1);
            }else{
                maps.put(s.charAt(i), maps.get(s.charAt(i))+1);
            }
        }
        
        for(int j=0;j<t.length();j++){
            if(!mapt.containsKey(t.charAt(j))){
                mapt.put(t.charAt(j), 1);
            }else{
                mapt.put(t.charAt(j), mapt.get(t.charAt(j))+1);
            }
        }
        
        return mapt.equals(maps);
    }
}