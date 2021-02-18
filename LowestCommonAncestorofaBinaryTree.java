// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

public class LowestCommonAncestorofaBinaryTree {
    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution {
        TreeNode result;//class level variable
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            findLCA(root, p, q);//helper function ot find LCA
            return result;
        }

        //post order traversal(left->right and then logic)
        private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return false;
            boolean left = findLCA(root.left, p, q);
            boolean right = findLCA(root.right, p, q);
            boolean curr = root == p || root == q;

            //conditoing when LCA is found
            if((left&&right) || (left && curr) || (right&&curr)) result = root;
            return left || right || curr;
        }
    }
}