// Time Complexity :O(log n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
we using an itterative approach here, since p and q will definatly be there 
we will use the properties of the BST to solve this one,
if p and q are bigger then root move right or if both are smaller then root move left
else return root
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}