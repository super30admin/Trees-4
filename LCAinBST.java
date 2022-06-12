// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: no
// Your code here along with comments explaining your approach: if both p and q are in the same side of the tree, then run the function on the that side of the tree. 
//                                                              Otherwise when p and q are in the different side of the tree, thats the common ancestor.

public class LCAinBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal > rootVal && qVal > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < rootVal && qVal < rootVal) {
            return lowestCommonAncestor(root.Left, p, q);
        } else
            return rootVal;
    }
}
