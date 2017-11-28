/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用
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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if(root == null){
            
            return false;
        }else if(root.left == null && root.right == null){
            
            return root.val == sum;
        }else{
            
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        }

    }
}