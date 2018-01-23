/*
 时间复杂度 O(n)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，使用递归搜索的方法，当root非空时，对root->left和root->right分别进行搜索。
 若搜索结果均非空，说明两个节点分别位于左右子树之中，LCA则为root；若只有一个结果为空，则LCA是另一个非空的节点；若结果均空，则返回NULL。
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
        
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);
        
        if(left!=null && right!=null){
            return root;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }
}