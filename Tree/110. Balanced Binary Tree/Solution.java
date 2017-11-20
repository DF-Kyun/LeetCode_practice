/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，每一个节点的左右子树都相差不大于一
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
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1){
            return false;
        }
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}