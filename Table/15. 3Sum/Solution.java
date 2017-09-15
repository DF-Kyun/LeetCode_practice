/*
 时间复杂度 O(n^2)
 空间复杂度 O(n) 

 1、先排序
 2、外循环i记录第一个数字，内部用指针对撞，当sum>0，移动左坐标，sum < 0,移动右坐标，
 碰到sum ＝ nums[i] + nums[left] + nums[right]时，把三个数字存到temp里，并把list存到最外面的res里面。
 3、注意数字重复的情况，用了hashset来解决第一位数字重复的问题，更新secondNum来保证第二位不重复

*/


class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(!set.add(nums[i])){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            
            int sum = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            int secondNum = nums[left];
            while(left < right){
                if(left != i+1 && nums[left] == secondNum){
                    left++;
                    continue;
                }
                if(nums[left] + nums[right] == sum){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    secondNum = nums[left];
                    temp.add(nums[left++]);
                    temp.add(nums[right--]);
                    res.add(temp);
                    
                }else if(nums[left] + nums[right] < sum){
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