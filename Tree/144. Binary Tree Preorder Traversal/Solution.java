/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：递归，但是需要新建一个方法，把返回值List带入每次递归
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root != null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
        
        return result;
    }
    
    public void preorder(TreeNode root, List<Integer> result){
        if(root != null){
            result.add(root.val);
            preorder(root.left, result);
            preorder(root.right, result);
        }
    }
}