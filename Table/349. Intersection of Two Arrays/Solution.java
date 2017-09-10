/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 利用Set去重
*/


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        
        for(int a : nums1){
            set1.add(a);
        }
        
        for(int b : nums2){
            if(set1.contains(b)){
                set2.add(b);
            }
        }
        
        int[] res = new int[set2.size()];
        int j = 0;
        for(Integer i : set2){
            
            res[j] = i;
            j++;
        }
        
        return res;
    }
}