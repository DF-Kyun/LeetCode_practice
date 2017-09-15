/*
 时间复杂度 O(n)
 空间复杂度 O(n) 

 基本思路：对于当前元素nums[i]，在查找表中寻找target-nums[i],如果存在返回，否则继续下一个
 注意：采用边查找边放入的方式，而不是一次性放入再查找，一是节省时间，一次遍历即可，二是防止相同元素被覆盖，
 导致查找不到（例如target为14，存在两个7，如果覆盖一个，则找不到结果）

*/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i]) != null){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }else{
                map.put(nums[i], i);
            }
            
        }
        return res;
    }
}