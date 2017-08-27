/*
 时间复杂度 O(n)
 空间复杂度 O(1)
nums中, [0...k)的元素均为非0元素

遍历到第i个元素后,保证[0...i]中所有非0元素
都按照顺序排列在[0...k)中
同时, [k...i] 为0
*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0 ){
                if(i!=k){
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                }else{
                    k++;
                }
            }
        }
    }
}