/*
 时间复杂度 O(n)
 空间复杂度 O(1)

 算法思想：递归调用，从上向下的递归反转
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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return null;
        }
        
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        
        invertTree(root.left);
        invertTree(root.right);
        
        
        return root;
    }
}