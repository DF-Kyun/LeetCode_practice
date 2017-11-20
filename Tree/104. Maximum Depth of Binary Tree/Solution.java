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
    public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        
        return Math.max(leftDep, rightDep)+1;
    }
}