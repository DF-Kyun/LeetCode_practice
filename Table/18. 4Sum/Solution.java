/*
 时间复杂度 O(n^3)
 空间复杂度 O(1) 

 1、先排序
 2、外循环i记录第一个数字，第二层循环j记录第二个数，内部用指针对撞，当sum>0，移动左坐标，sum < 0,移动右坐标，
 碰到sum ＝ nums[i] + nums[j] + nums[left] + nums[right]时，把四个数字存到temp里，并把list存到最外面的res里面。
 3、注意数字重复的情况，可以采用以前的set方式，在第一层外围及第二层外围分别用set去重，这次使用的是向前判断
 是否和之前一个重复（不可以向后判断，向后就到了另个一个数的范围了）
*/


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return res;
        }
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int sum = target-nums[i]-nums[j];
                int left = j+1;
                int right = nums.length-1;
                int thirdNum = nums[left];
                while(left < right){
                    if(left != j+1 && nums[left] == thirdNum){
                        left++;
                        continue;
                    }
                    if(nums[left]+nums[right] == sum){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        thirdNum = nums[left];
                        temp.add(nums[left++]);
                        temp.add(nums[right--]);
                        res.add(temp);
                        
                    }else if(nums[left]+nums[right] < sum){
                        thirdNum = nums[left];
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            
        }
        
        return res;
    }
}