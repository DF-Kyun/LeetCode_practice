/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 如果i扫到的当前元素在k之前已经存在两个（注意，由于A是排好序的，因此只需要判断前两个就行），
 那么i继续前进。否则将i指向的元素覆盖k，k与i一起前进。
 只留两个相同的元素，其余的覆盖
*/



class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length <= 2){
            return nums.length;
        }
        
        int k = 2;
        for(int i=2; i<nums.length; i++){
            
            if(nums[i] != nums[k-2]){
                
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}