/*
 时间复杂度 O(n)
 空间复杂度 O(n)

 算法思想：利用队列的特点，层序遍历同一行的元素放入同一列表中，这里用变量mark来维护每一层元素的个数，
 具体地，每层开始时队列的大小就是该层元素个数，队列中加入下一层，把当前层放入返回值中。
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
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
            res.add(temp);
        }
        
        return res;
    }
}