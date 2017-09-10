/*
/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 利用Map记录次数
*/

*/


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int a : nums1){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }else{
                map.put(a, map.get(a)+1);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int b : nums2){
            if(map.containsKey(b) && map.get(b) > 0){
                list.add(b);
                map.put(b, map.get(b)-1);
            }
        }
        
        int[] res = new int[list.size()];
        int j = 0; 
        for(Integer i : list){
            res[j] = i;
            j++;
        }
        
        return res;
    }
}