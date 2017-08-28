/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 如果只能扫一遍，很容易想到的就是左边存放0和1，右边存放2.两边往中间靠。
 设置两个index，left记录第一个1的位置，left左边为0，right记录第一个非2的位置，right右边为2.
 然后使用i从头到尾扫一遍，直到与right相遇。
 i遇到0就换到左边去，遇到2就换到右边去，遇到1就跳过。
 需要注意的是：由于left记录第一个1的位置，因此A[left]与A[i]交换后，A[left]为0,A[i]为1，因此i++；
 而right记录第一个非2的位置，可能为0或1，因此A[right]与A[i]交换后，A[right]为2,A[i]为0或1，i不能前进，要后续判断。
*/


class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int i=0;
        
        while(i<=r){ 空间复杂度 O(1)

            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l++] = temp;
                i++;
            }else if(nums[i]==2){
                int temp1 = nums[i];
                nums[i] = nums[r];
                nums[r--] = temp1;
            }else{
                i++;
            }
            
        }


    }
}