// Time Complexity : O(h) The max time taken is height of the tree to find a node in BST
// Space Complexity : O(1) Because we're not recursing and moving the node to left or right
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class LCAofBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true){
            if(p.val>root.val && q.val>root.val) root = root.right;
            else if(p.val<root.val && q.val<root.val) root = root.left;

            //the moment p or q node becomes the root value
            else return root;
        }
    }
}