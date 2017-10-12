/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：迭代，从根节点开始,只要一直存在左节点就一直加左节点，并将左节点入栈，再出栈当前节点，遍历右节点。
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            root = temp.right;
            
        }
        
        return result;
    }
}