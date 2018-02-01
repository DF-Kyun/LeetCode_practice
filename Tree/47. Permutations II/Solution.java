/*
 时间复杂度 O(2^n)，n为数组的长度
 空间复杂度 O(n)

 算法思想：递归回溯，1、通过树形递归调用，遍历每种可能，因为不能重复使用同一个元素，需要使用一个boolean数组存储用过的值
 2、将每次调用之后的结果存入结果集中，之后回溯，将分支置为之前的状态  3、判断之后的数字是否一样，如果一样，就直接跳过（相当于剪枝）
*/


 class Solution {
    
    private List<List<Integer>> res;
    private boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        
        used = new boolean[nums.length];
        Arrays.sort(nums);
        LinkedList<Integer> p = new LinkedList<Integer>();
        
        subpermuteUnique(nums, 0, p);
        
        return res;
        
    }
    
    private void subpermuteUnique(int[] nums, int index, LinkedList<Integer> p){
        
        if(index == nums.length){
            
            res.add((LinkedList<Integer>)p.clone());
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                subpermuteUnique(nums, index+1, p);
                p.removeLast();
                used[i] = false;

                while(i<nums.length-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        
        return;
    }
}