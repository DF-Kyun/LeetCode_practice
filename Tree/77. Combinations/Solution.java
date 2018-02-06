/*
 时间复杂度 O(n^k)
 空间复杂度 O(k)

 算法思想：递归回溯，1、求解C(n,k), 当前已经找到的组合存储在c中, 需要从start开始搜索新的元素，2、剪枝操作减少遍历次数，每次向下遍历需要还有k - c.size()个空位, 
 所以, [i...n] 中至少要有 k - c.size() 个元素，i最多为 n - (k - c.size()) + 1）
 */


 class Solution {
    
    private ArrayList<List<Integer>> res;
    
    public List<List<Integer>> combine(int n, int k) {
        
        res = new ArrayList<List<Integer>>();
        
        if(k<=0 || n<=0 || k>n){
            return res;
        }
        
        LinkedList<Integer> c = new LinkedList<Integer>();
        subCombine(n, k, 1, c);
        
        return res;
        
    }
    
    private void subCombine(int n, int k, int start, LinkedList<Integer> c){
        
        if(k == c.size()){
            
            res.add((List<Integer>)c.clone());
            return;
        }
        
        for(int i=start; i<=n-(k-c.size())+1; i++){
            
            c.addLast(i);
            subCombine(n, k, i+1, c);
            c.removeLast();
        }
        
        return;
        
    }
}