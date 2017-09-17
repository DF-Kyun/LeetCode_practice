/*
 时间复杂度 O(n^2)
 空间复杂度 O(1) 

 1、先排序
 2、外循环i记录第一个数字，内部用指针对撞。
 3、增加数字重复判断，减低运行时间
*/


class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            
            int left = i+1;
            int right = nums.length-1;
            int secondNum = nums[left];
            while(left < right){
                if(left != i+1 && nums[left] == secondNum){
                    left++;
                    continue;
                }
                int temp = target-nums[left]-nums[right]-nums[i];
                if(Math.abs(temp) < diff){
                    diff = Math.abs(temp);
                    res = nums[left]+nums[right]+nums[i];
                    
                } 
                if(temp > 0){
                    secondNum = nums[left];
                    left++;
                }else{
                    right--;
                }
                
            }
        }
        return res; 
    }
}