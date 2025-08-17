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
    

    // Bottom up recursion - Best approach - not using list to store at all.
    // TC: O(n)
    // SC: O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // everything below can  be simplifies as return left != null ? left : right;
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        return root;
        
    }

    // 2 paths and compare the paths to find the LCA.
    // TC: O(n)
    // SC: O(h)
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor2Lists(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        pathP = new ArrayList<>();
        pathQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());

        // since we added a padded number at the end, we do not need to find this smaller logic.
        // but will be a problem if p and q are same. can add base condition to check that first.
        int smallLen = pathP.size() <= pathQ.size() ? pathP.size() : pathQ.size();
        for (int i = 0; i < smallLen; ++i) {
            if (pathP.get(i) != pathQ.get(i)) {
                return pathP.get(i - 1);
            }
        }

        return null;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (root == null) {
            return;
        }

        // both found. can stop proceeding
        // if (pathP.size() > 0 && pathQ.size() > 0) {
        //     return;
        // }

        path.add(root);

        if (root == p) {
            pathP = new ArrayList<>(path);
            // useful when comparing arrays at the end. check example 2. 2 paths will be constructe as 35244 and 355. 
            pathP.add(root);
        }

        if(root == q) {
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }

        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);

        path.remove(path.size() - 1);
        
    }

    
}
