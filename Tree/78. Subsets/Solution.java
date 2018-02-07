/*
 时间复杂度 O(n^n)，n为数组的长度
 空间复杂度 O(2^n)

 算法思想：递归回溯，1、通过树形深度递归调用，遍历每种可能，把每次的结果添加到结果集中  2、当 start == nums.length 时，表示遍历到底，返回 
 3、在第一次调用方法时会将空的子结果集放入结果集中
*/


 class Solution {
    
    private ArrayList<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
    
        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        
        LinkedList<Integer> c = new LinkedList<Integer>();
        sub_subsets(nums, 0, c);
        
        return res;
    }
    
    private void sub_subsets(int[] nums, int start, LinkedList<Integer> c){
        
        res.add((List<Integer>)c.clone());
        
        if(start == nums.length){
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            
            c.addLast(nums[i]);
            sub_subsets(nums, i+1, c);
            c.removeLast();
        }
        
        return;
    }
}