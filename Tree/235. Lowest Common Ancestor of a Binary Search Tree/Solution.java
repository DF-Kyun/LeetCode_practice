/*
 时间复杂度 O(log*n)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，分三种情况，两个节点都在根的左侧（以根的左节点为根递归），两个节点都在根的右侧（以根的右节点为根递归），两个节点在根的两侧
 （这种情况有可能为其中一个节点为根，但是都是以根为父节点）
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
}