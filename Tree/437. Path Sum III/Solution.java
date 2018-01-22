/*
 时间复杂度 O(n)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，分两种情况，当前节点在路径中的（findPath）和当前节点不在路径中的（pathSum），当前节点在路径中的向下递归路径（注意有负数的情况，即使当前值为sum，
 但是可以后面有负数使值继续为sum），当前节点不在路径中的向下递归以左右子树为根的情况，最后统计两种情况的和
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
    public int pathSum(TreeNode root, int sum) {
        
        if(root == null){
            return 0;
        }
        
        return findPath(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }
    
    private int findPath(TreeNode root, int sum){
        
        if(root == null){
            return 0;
        }
        
        int res = 0;
        if(root.val == sum){
            res += 1;
        }
        
        res += findPath(root.left, sum-root.val);
        res += findPath(root.right, sum-root.val);
        
        return res;
    }
}