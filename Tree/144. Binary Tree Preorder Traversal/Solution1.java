/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：迭代，从根节点开始入栈，将当前节点入栈，当栈非空时，出栈当前元素，先入右节点，再入左节点（之后先出栈的是左节点）。
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
        
        if(root != null){
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                result.add(root.val);
                if(root.right != null){
                    stack.push(root.right);
                }
                if(root.left != null){
                    stack.push(root.left);
                }
            }
        }
        
        return result;
    }
}