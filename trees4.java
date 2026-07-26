//problem1
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
    ArrayList<Integer> path;
    public int kthSmallest(TreeNode root, int k) {
        this.path=new ArrayList<>();
        helper(root);
        return path.get(k-1);
    }
    private void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        path.add(root.val);
        helper(root.right); 
    }
}
//problem2
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      while(true)
        if(p.val<root.val && q.val<root.val) root=root.left;
        else if(p.val>root.val && q.val>root.val) root=root.right;
        else return root;
    }
}
//problem3
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null) return null;
        else if(left!=null && right==null) return left;
        else if(left==null && right!=null) return right;
        else return root;
    }
}
