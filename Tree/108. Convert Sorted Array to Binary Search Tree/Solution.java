/*
 时间复杂度 O(n)， n为树的节点个数
 空间复杂度 O(h), h为树的高度

 算法思想：递归，每次找到数组的中间位置，这个便是BST的根节点。左右孩子也很好找，
 根节点左边区域的中间节点便是左孩子，根节点的右边区域的中间节点便是右孩子。如此递归求解。
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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return dfs(nums, 0, nums.length-1);
    }
    
    private TreeNode dfs(int[] nums, int start, int end){
        if(end < start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid-1);
        root.right = dfs(nums, mid+1, end);
        
        return root;
    }
}