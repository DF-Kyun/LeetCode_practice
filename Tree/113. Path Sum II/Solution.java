/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，深度遍历二叉树，并将满足条件的加入返回结果
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> alist = new ArrayList<Integer>();
        
        if(root != null){
            dfs(root, list, alist, sum);
        }
        
        return list;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> list, List<Integer> alist, int sum){
        
        if(root.left == null && root.right == null){
            if(root.val == sum){
                alist.add(root.val);
                list.add(new ArrayList<Integer>(alist));
            }
            
            return;
        }
        
        alist.add(root.val);
        
        if(root.left == null){
            dfs(root.right, list, alist, sum-root.val);
        }else if(root.right == null){
            dfs(root.left, list, alist, sum-root.val);
        }else{
            List alistcopy = new ArrayList<Integer>(alist);
            dfs(root.right, list, alist, sum-root.val);
            alist = alistcopy;
            dfs(root.left, list, alist, sum-root.val);
        }
    }
}