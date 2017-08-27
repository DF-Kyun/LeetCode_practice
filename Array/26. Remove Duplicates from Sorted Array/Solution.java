/*
 时间复杂度 O(n)
 空间复杂度 O(1)

两个角标控制数组，数组已排序，所以[0,k]表示不重复的，
采用覆盖的方式，当相等时i加一跳过，k保持不变，
不相等时，k加一，覆盖赋值，把跳过的重复值覆盖掉
*/



class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        for(int i=0; i<nums.length; i++){
            
            if(nums[i] != nums[k]){
                
                k++;
                if(k != i){
                    nums[k] = nums[i];
                }
                
            }
        }
        
        return k+1;
    }
}