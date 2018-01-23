/*
 时间复杂度 O(logn)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，递归是可以回溯的, 所以不需要记录父节点. 然后考虑删除以后节点的替换. 有四种替换方式:
	1. 如果要删除的节点有左孩子, 则可以直接让左孩子替换其位置, 并且让左孩子的右子树连接到要删除节点的右孩子的最左端
	2. 如果要删除的节点有右孩子, 则可以让右孩子替换其位置, 并且让右孩子的左子树连接到要删除节点的左孩子的最右端
	3. 如果要删除的节点有左孩子, 则可以取左孩子的最右节点替换要删除的节点
	4. 如果要删除的节点有右孩子, 则可以去右孩子的最左节点替换要删除的节点.
 在这里采用的第二种解法.
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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null){
            return root;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        
        if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = left;
        
        if(left == null || right == null){
            return left!=null ? left : right;
        }
        
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right.left;
        right.left = left;
        
        return right;
    }
}