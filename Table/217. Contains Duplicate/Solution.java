/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 利用set集合元素唯一性
*/


class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}