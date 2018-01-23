/*
 时间复杂度 O(nlogn)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，
 1、计算左子树元素个数left。
 2、 left+1 = K，则根节点即为第K个元素
     left >=k, 则第K个元素在左子树中，
     left +1 <k, 则转换为在右子树中，寻找第k-left-1元素。
 依次递归。
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
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null){
            return 0;
        }
        
        int leftSize = getTreeSize(root.left);
        if(k == leftSize+1){
            return root.val;
        }else if(k <= leftSize){
            return kthSmallest(root.left, k);
        }else{
            return kthSmallest(root.right, k-leftSize-1);
        }
    }
    
    public int getTreeSize(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return 1+getTreeSize(root.left)+getTreeSize(root.right);
    }
}