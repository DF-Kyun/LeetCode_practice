/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用队列的特点，与102类似，将返回值改为LinkedList，通过add(int index, E element) 添加到头位置。
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null){
            return res;
        }
        
        q.offer(root);
        int mark = 0;
        while(!q.isEmpty()){
            mark = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            TreeNode tmpnode = new TreeNode(0);
            for(int i=0; i<mark; i++){
                tmpnode = q.poll();
                temp.add(tmpnode.val);
                if(tmpnode.left != null){
                    q.offer(tmpnode.left);
                }
                if(tmpnode.right != null){
                    q.offer(tmpnode.right);
                }
            }
            res.add(0, temp);
        }
        
        return res;
    }
}