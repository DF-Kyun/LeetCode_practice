/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：迭代，从根节点开始入栈，只要一直存在左节点就一直入栈，不存在左节点就出栈访问节点值，然后继续遍历出栈那个节点的右节点。
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            root = temp.right;
        }
        
        return result;
    }
}