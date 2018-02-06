/*
 时间复杂度 O(n^k)
 空间复杂度 O(k)

 算法思想：递归回溯，1、递归终止条件为当前的元素和等于 target  2、递归深度遍历求解所有的可能组合，如果当前的元素和大于求解的和，则返回上一层
 对于是否需要在求解之前排序，因为不存在负数及零的元素，求和是一个递增的过程
 */


class Solution {
    
    private ArrayList<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    
        res = new ArrayList<List<Integer>>();
        
        if(candidates == null || candidates.length == 0){
            return res;
        }
        
        LinkedList<Integer> c = new LinkedList<Integer>();
        subcombinationSum(candidates, target, 0, 0, c);
        
        return res;
    }
    
    private void subcombinationSum(int[] array, int target, int sum, int start, LinkedList<Integer> c){
        
        if(sum == target){
            
            res.add((List<Integer>)c.clone());
            return;
        }else if(sum > target){
            
            return;
        }else{
                   
            for(int i=start; i<array.length; i++){

                c.addLast(array[i]);
                subcombinationSum(array, target, sum+array[i], i, c);
                c.removeLast();
            } 
        }
        
        return;
    }
}