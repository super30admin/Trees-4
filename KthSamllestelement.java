//Recursive
//TimeCompelxity: o(n)
//space complexity: o(n)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> arr;
    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        helper(root);
        return arr.get(k-1);
    }
    
    private void helper(TreeNode root)
    {
        if(root == null)return;
        
        helper(root.left);
        arr.add(root.val);
        helper(root.right);
    }
}