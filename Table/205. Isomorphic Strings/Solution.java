/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

s和t是一一对应的关系的时候返回true,否则就为false，
可以用map数据结构来实现。要注意的是，map中不同的key可以对应相同的value，需要注意下，
这里用一个set记录出现过的value，如果key未出现过，而value出现过，则表示出现不同key对应相同value
可以理解为map存储s-->t的对应关系，set存储是否有t-->s反向对应不一致的
*/


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(map.containsKey(sc)){
                if(!map.get(sc).equals(tc)){
                    return false;
                }
            }else{
                if(set.contains(tc)){
                    return false;
                }
                map.put(sc, tc);
                set.add(tc);
                
            }
        }
        
        return true;
    }
}