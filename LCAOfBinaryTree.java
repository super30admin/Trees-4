// Time Complexity : O(n)
// Space Complexity : O(2n) for both the paths constructed + O(h) for recursion stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Construct paths upto p & q both
//Compre the paths, LCA will be the point at which the paths diverge.

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

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        constructPath(root, p, path1);
        constructPath(root, q, path2);

        for (int i = 1; i< path1.size(); i++) {

            if(path1.get(i) != path2.get(i)) {
                return path1.get(i-1);
            }
        }
        return null;
    }

    private void constructPath(TreeNode root, TreeNode target, List<TreeNode> path){
        //base
        if(root == null) return;
        if(root == target) {
            path.add(root);
            path.add(root);
            return;
        }

        //logic
        path.add(root);
        constructPath(root.left, target, path);
        constructPath(root.right, target, path);

        if(path.get(path.size() -1) == target) {
            return;
        }
        path.remove(root);

    }
}
