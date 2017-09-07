/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 两个指针, l r, r向后走,直到 sum 大于 s. 然后l向后, 直到sum 小于s. 同时更新 min值.
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        while(r<nums.length){
            
            while(sum<s && r<nums.length){
                sum += nums[r++];
            }
            
            while(sum>=s && l<=r){
                min = Math.min(min, r-l);
                sum -= nums[l++];
            }
        
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}