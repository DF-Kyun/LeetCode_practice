/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用队列的特点，与102类似，最后每隔一次反转List集合。
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null){
            return res;
        }
        
        q.offer(root);
        int mark = 0;
        while(!q.isEmpty()){
            mark = q.size();
            List<Integer> temp = new ArrayList<Integer>();
            TreeNode tempnode = new TreeNode(0);
            for(int i=0; i<mark; i++){
                tempnode = q.poll();
                temp.add(tempnode.val);
                if(tempnode.left != null){
                    q.offer(tempnode.left);
                }
                if(tempnode.right != null){
                    q.offer(tempnode.right);
                }
            }
            res.add(temp);
        }
        
        for(int i=1; i<res.size(); i+=2){
            Collections.reverse(res.get(i));
        }
        
        return res;
    }
}