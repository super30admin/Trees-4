
//Approach: Iterative approach
//We will compare the root value with p and q value if its higher than both of them we will move to left or if its lower than both of them we will  move right or else we will return the root. 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        while(root != null)
        {
            if(root.val > p.val && root.val > q.val)root = root.left;
            else if(root.val < p.val && root.val < q.val)root = root.right;
            else return root;
        }
        return null;
    }
}
//Time Complexity : O(log n) since its a BST 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

//Approach: Recursive approach
//We will compare the root value with p and q value if its higher than both of them we will move to left or if its lower than both of them we will  move right or else we will return the root.
class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val > p.val && root.val > q.val)return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}
//Time Complexity : O(log n) since its a BST 
//Space Complexity : O(h) height of the tree for the recursive stack
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
