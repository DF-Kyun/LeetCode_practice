/*
 时间复杂度 O(n)
 空间复杂度 O(t) t字符串的长度

 使用一个map 来储存 字符 和 在 t 中出现次数的映射关系。
 然后要用到two pointers 来保持一个 window，cnt 来表示 t 中 所对应数，
 例子中 如果 cnt 是3， 表示 T 被全部覆盖。用start 来记录minLength 的 左边界。

 参考博客：http://blog.csdn.net/sundawei2016/article/details/75213070

*/


class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<t.length();i++){
             if(!map.containsKey(t.charAt(i))){
                 map.put(t.charAt(i), 1);
             }else{
                 map.put(t.charAt(i), map.get(t.charAt(i))+1);
             }
        }
        
        int l = 0;
        int start = 0;
        int count = 0;
        int minlen = s.length()+1;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j))>=0){
                    count++;
                }
                while(count == t.length()){
                    if(j-l<minlen){
                        minlen = j-l+1;
                        start = l;
                    }
                    if(map.containsKey(s.charAt(l))){   //恢复值，恢复map，恢复计数器count
                        map.put(s.charAt(l), map.get(s.charAt(l))+1);
                        if(map.get(s.charAt(l)) > 0){
                            count--;
                        }
                    }
                    l++;
                }
            }
        }
        
        return minlen>s.length()?"":s.substring(start, start+minlen);
    }
}