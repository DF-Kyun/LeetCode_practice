/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：迭代，从根节点开始,只要一直存在左节点就一直加左节点，并将左节点入栈，
 当栈非空时，查看栈顶元素，如果当前元素的右节点为空或已遍历，则遍历当前节点并记录，
 否则将当前节点作为根节点遍历。
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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = root;
        
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            if(!stack.isEmpty()){
                TreeNode temp = stack.peek().right;
                if(temp == null || temp == pre){
                    root = stack.pop();
                    result.add(root.val);
                    pre = root;
                    root = null;
                }else{
                    root = temp;
                }                
            }
        }
        
        return result;
    }
}