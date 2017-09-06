/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 指针对撞
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int water = 0;
        int temp;
        while(l<r){
            temp = (r-l)*min(height[l], height[r]);
            water = max(temp, water);
            
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
            
        }
        return water;
    }
    
    public int min(int a, int b){
        if(a<b){
            return a;
        }else{
            return b;
        }
    }
    
    public int max(int a, int b){
        if(a<b){
            return b;
        }else{
            return a;
        }
    }
}