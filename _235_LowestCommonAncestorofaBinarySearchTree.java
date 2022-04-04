

// Time Complexity : o(h) - h is height of tree ( o(n) is worst case when tree is skewed and log(n) when tree is balanced)
// Space Complexity : o(h) - h is height of tree( o(n) is worst case when tree is skewed and log(n) when tree is balanced)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Since its is a BST then if both p and q are less than root then go left if both greater than root thrn go right else you found the lca
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null){
            if(root.val > p.val && root.val >  q.val ){
                root = root.left;
            }
            else if(root.val < p.val && root.val <  q.val ){
                 root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
