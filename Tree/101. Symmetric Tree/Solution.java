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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        return checkNodes(root.left, root.right);
    }
    
    public boolean checkNodes(TreeNode node1, TreeNode node2){
        
        if(node1 == null && node2 == null){
            return true;
        }
        
        if(node1 == null || node2 == null){
            return false;
        }
        
        if(node1.val != node2.val){
            return false;
        }else{
            return checkNodes(node1.left, node2.right) && checkNodes(node1.right, node2.left);
        }
        
    }
}