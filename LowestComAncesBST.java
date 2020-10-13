// Time Complexity : O(log n) most of the times, worst case O(n) (Amortized O(n))
// Space Complexity : O(n) for recursive stack, else O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//we can use the property of BST sort, when both p&q are lesser than root, recursively call the funct on left subtree
//if both are greater than root, then go to the right subtree
//if they are on either side , then our current position(i.e curr root) is the answer

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val<root.val &&q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(p.val>root.val&&q.val>root.val){
           return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
       
    }
}