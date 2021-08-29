//Time complexity: O(N)
//space complexity: O(h)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LCAbinary {
    List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root ==  q)
            return root;
        
        
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null)
            return root;
        else if(left != null)
            return left;
        else if(right != null)
            return right;
        else
            return null;
    }
    
}