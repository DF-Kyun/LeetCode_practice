/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，获取所有的路径值，相加
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
    
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        
        if(root == null){
            return sum;
        }
        
        dfs(root, root.val);
        
        return sum;
    }
    
    public void dfs(TreeNode root, int num){
        
        if(root.left == null && root.right == null){
            sum += num;
        }
        
        if(root.left != null){
            dfs(root.left, num*10 + root.left.val);
        }
        
        if(root.right != null){
            dfs(root.right, num*10 + root.right.val);
        }
    }
    
}