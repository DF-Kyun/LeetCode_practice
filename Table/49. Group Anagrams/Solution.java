/*
 时间复杂度 O(n^2*logn)
 空间复杂度 O(n) 

 解题思路：遍历数组中的每个字符串，并对字符串中的字符排序，将排序后的字符作为key存入map中，
 则最后map中每个key对应的就是一组anagrams
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        
        char[] tempChar;
        String tempStr;
        ArrayList<String> tempList;
        for(int i=0;i<strs.length;i++){
            tempChar = strs[i].toCharArray();
            Arrays.sort(tempChar);
            tempStr = new String(tempChar);
            if(map.containsKey(tempStr)){
                tempList = map.get(tempStr);
                tempList.add(strs[i]);
            }else{
                ArrayList<String> templist = new ArrayList<String>();
                templist.add(strs[i]);
                map.put(tempStr, templist);
            }
        }
        
        for(ArrayList<String> value : map.values()){
            res.add(value);
        }
        
        return res;
    }
}