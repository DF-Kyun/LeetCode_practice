/*
 时间复杂度 O(n^k)
 空间复杂度 O(k)

 算法思想：递归回溯，1、递归终止条件为当前的元素和等于 n  2、递归深度遍历求解所有的可能组合，如果当前的元素和大于求解的和，或者剩余元素的个数小于0，
 则返回上一层
 */


 class Solution {
    
    private ArrayList<List<Integer>> res;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        res = new ArrayList<List<Integer>>();
        
        if(k<1 || n<1){
            return res;
        }
        
        LinkedList<Integer> c = new LinkedList<Integer>();
        subcombinationSum3(k, n, 1, 0, c);
        
        return res;
    }
    
    private void subcombinationSum3(int k, int n, int start, int sum, LinkedList<Integer> c){
        
        if(sum == n && k == 0){
            
            res.add((List<Integer>)c.clone());
            return;
        }else if(sum > n || k < 0){
            
            return;
        }else{
            
            for(int i=start; i<=9; i++){
                
                c.addLast(i);
                subcombinationSum3(k-1, n, i+1, sum+i, c);
                c.removeLast();
            }
        }
        
        return;
    }
}