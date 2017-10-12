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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(root != null){
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);  
        }
        
        return result;
    }
    
    public void postorder(TreeNode root, List<Integer> result){
        if(root != null){
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);
        }
    }
}