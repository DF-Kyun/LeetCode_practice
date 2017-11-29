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
    public List<String> binaryTreePaths(TreeNode root) {
        
        ArrayList<String> res = new ArrayList<String>();
        
        if(root == null){
            return res;
        }
        
        if(root.left == null && root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }
        
        List<String> leftList = binaryTreePaths(root.left);
        for(String s : leftList){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        
        List<String> rightList = binaryTreePaths(root.right);
        for(String s : rightList){
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        
        return res;
    }
}