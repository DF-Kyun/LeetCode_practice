/*
 时间复杂度 O(n)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，每个结点都得和两个数比，它必须在这两个数的范围之内（左右的所有节点均需要大于或者小于根，所以需要有个区间），其中一个就是它的父节点，另外一个是它的某个祖先借点，
 这个树是从上往下遍历的，遍历到每个节点时，都要把它限定在一个已知的范围内，不管他下面的节点，只根据他上面的节点
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
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        return rangeMethod(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean rangeMethod(TreeNode root, double low, double high){
        
        if (root.val <= low || root.val >= high) {
            return false;
        }
        if (root.left != null && !rangeMethod(root.left, low, root.val)) {
            return false;
        }
        if (root.right != null && !rangeMethod(root.right, root.val, high)) {
            return false;
        }
        return true;
    }
}