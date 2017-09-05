/*
 时间复杂度 O(n) (in quickselect)
 空间复杂度 O(1)

 Quick Select算法的基本思路与Quick Sort类似，重点是partition
 基本思想，随机选取一个pivot，小于的放左边，大于等于的放右边，返回pivot的位置
    如果pivot == k，则正好找到了第k小的元素
    如果pivot > k，则第k小的元素存在于pivot左边
    如果pivot < k，则第k小的元素存在于pivot右边

*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        int kth = nums.length-k;
        
        return partition(nums,l,r,kth);
        
    }
    
    public int partition(int[] num, int low, int high, int kth){
        int l = low;
        int r = high;
        int x = num[l];
        
        while(l<r){
            
            while(l<r && num[r] >= x){
                r--;
            }
                
            
            if(l<r){
                num[l++] = num[r];
            }
            
            while(l<r && num[l] <= x){
                l++;
            }
                
            
            if(l<r){
                num[r--] = num[l];
            }            
                
        }
        
        num[l] = x;
        
        if(l == kth){
            return num[l];
        }else if(l > kth){
            return partition(num,low,l-1,kth);
        }else{
            return partition(num,l+1,high,kth);
        }
    }
}