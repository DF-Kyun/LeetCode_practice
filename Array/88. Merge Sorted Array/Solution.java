/*
 时间复杂度 O(n+m)
 空间复杂度 O(1)
 
 利用nums1数组的后m的空间，进行排序
 比较nums1与nums2数组的大小，分别从nums1和nums2最后的元素开始向前比较  
 如果nums1[i]较大，将nums1[i]值放在组合后的最后位置  
 i左移1位
 反之放nums2[j]到组合后的最后位置
 另外，如果nums2数组中较小的数据较长，没有排序完，需要单独排序下
*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i--];
            }else{
                nums1[k] = nums2[j--];
            }
            k--;
        }
        
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}