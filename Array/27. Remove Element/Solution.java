/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 解法如283题一样，利用两个角标，控制隔离等于val和不等于val的数，
 程序保留了原有数组的顺序及val的值，
 可以不保留val的值，直接覆盖
 数据交换部分代码可以直接用
 nums[k++] = nums[i]
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val ){
                if(i!=k){
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                }else{
                    k++;
                }
            }
        }
        
        return k;
    }
}