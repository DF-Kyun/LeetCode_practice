/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 pattern的字符和str划分后的单词是一一对应的关系的时候返回true,否则就为false，
 可以用map数据结构来实现。要注意的是，map中不同的key可以对应相同的value，需要注意下，
 这里用一个set记录出现过的value，如果key未出现过，而value出现过，则表示出现不同key对应相同value

*/


class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() != str.split(" ").length){
            return false;
        }
        
        char[] patternArr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(patternArr[i])){
                if(!map.get(patternArr[i]).equals(strArr[i])){
                    return false;
                }
            }else{
                if(set.contains(strArr[i])){
                    return false;
                }
                map.put(patternArr[i], strArr[i]);
                set.add(strArr[i]);
            }
        }
        
        return true;
    }
}