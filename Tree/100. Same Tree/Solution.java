/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，判断每一个元素是否相同
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return (p == null && q == null ||
               (p != null && q != null && p.val == q.val) &&
               (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)));
        
    }
}