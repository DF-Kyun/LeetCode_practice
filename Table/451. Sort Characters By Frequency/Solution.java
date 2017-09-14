/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 采用map存储字符和出现的次数的对应关系，map根据出现次数排序，输出结果

*/


class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            char sc = s.charAt(i);
            if(map.containsKey(sc)){
                map.put(sc, map.get(sc)+1);
            }else{
                map.put(sc, 1);
            }
        }
        
        List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                    Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> m : list){
            for(int j=0;j<m.getValue();j++){
                    sb.append(m.getKey());
            }
        }
        
        return sb.toString();
    }
}