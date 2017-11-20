/*
 时间复杂度 O(h^2)
 空间复杂度 O(1)

 算法思想：如果从某节点一直向左的高度 = 一直向右的高度, 那么以该节点为root的子树一定是complete binary tree. 
 而 complete binary tree的节点数,可以用公式算出 2^h - 1. 如果高度不相等, 则递归调用 return countNode(left) + countNode(right) + 1. 
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
    public int countNodes(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        int leftDep = 0;
        int rightDep = 0;
        for(TreeNode node=root; node!=null; node=node.left){
            leftDep++;
        }
        for(TreeNode node=root; node!=null; node=node.right){
            rightDep++;
        }
        
        if(leftDep == rightDep){
            return (2<<(leftDep-1))-1;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}