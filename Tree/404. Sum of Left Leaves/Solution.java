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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}