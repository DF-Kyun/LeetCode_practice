/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：迭代，模拟系统栈的调用方式，借助Command将要遍历的二叉树压入系统栈
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

public class Command {
    String s;
    TreeNode node;
    Command(String cs, TreeNode cnode){
        s = cs;
        node = cnode;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.isEmpty()){
            
            Command command = stack.pop();
            
            if(command.s.equals("print")){
                result.add(command.node.val);
            }else{
                satck.push(new Command("print", command.node));
                if(command.node.right != null){
                    stack.push("go", command.node.right);
                }
                if(command.node.left != null){
                    satck.push("go", command.node.left);
                }
            }
        }

        return result;    
    }
}
