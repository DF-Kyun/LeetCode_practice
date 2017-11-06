/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用队列的特点，与102类似，广度遍历，获取队列最后的元素。
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if(root == null){
            return res;
        }
        
        q.offer(root);
        int mark = 0;
        while(!q.isEmpty()){
            mark = q.size();
            for(int i=1; i<=mark; i++){
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }

                if(i == mark){
                    res.add(temp.val);
                }
            }
        }
        
        return res;
    }
}