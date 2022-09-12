//TC - O(H+k)
//SC - O(H)
//LC - 230

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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            
            root = stack.pop();
            
            if(--k == 0) return root.val;
            
            root=root.right;
        }
    }

}