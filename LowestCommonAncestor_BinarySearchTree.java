/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//TC - O(log n) SC - O(h) --recursive
//TC - O(log n) SC - O(1) --iterative
class Solution20 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return helper(root,p,q); //TC - O(log n) SC - O(h)
        return iterative(root,p,q);  //TC - O(log n) SC - O(1)
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root.val>p.val && root.val>q.val){
            return helper(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val){
            return helper(root.right,p,q);
        }
        else
            return root;
    }
    /**Iterative soln */
    private TreeNode iterative(TreeNode root, TreeNode p, TreeNode q){
        while(true){
        if(root.val>p.val && root.val>q.val){
            root = root.left;
        }
        else if(root.val<p.val && root.val<q.val){
            root=root.right;
        }
        else
            return root;
        }
        
    }
}
public class LowestCommonAncestor_BinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
