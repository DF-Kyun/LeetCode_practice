/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 指针对撞，两个指针分别从两侧开始，
 因为不能使用同个元素两次，所以两个指针不能重叠（l<r而不是l<=r）
 如果和等于结果，直接返回
 大于结果，缩小和，减小右边界，
 小于结果，增大和，增加左边界
*/


class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        int[] result = new int[2];
        int sum;
        while(l<r){
            sum = numbers[l]+numbers[r];
            if(sum == target){
                result[0] = l+1;
                result[1] = r+1;
                break;
            }else if(sum > target){
                r--;
            }else{
                l++;
            }
        }
        return result;
    }
}