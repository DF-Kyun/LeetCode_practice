/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 基本思想：滑动窗口+查找表，滑动窗口用set表示，控制set集合大小为k，在集合中查找满足条件的元素

*/


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}