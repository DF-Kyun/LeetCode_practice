/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，对于最小深度，需要考虑当前子树是否为单子树的情况，
 对于双子树，其最小深度为左右子树的最小值，对于单子树，其最小深度为左右深度的最大值（因为一侧的子树为0，需取另一侧）.
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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(root.left == null){
            return minDepth(root.right)+1;
        }
        if(root.right == null){
            return minDepth(root.left)+1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
}