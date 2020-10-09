//Time Complexity: O(logn) most cases, but if all nodes are on left or right then it is O(n) like worst case
//Space Complexity: O(logn) recursive stack and O(n) for worst case
//Did it run on leetcode: yes
/**Approach: if p is on one side and q is on side then root will be the output
 else if both are less recursion on left tree
 else if both are greater than root recursion on right tree**/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root==null)
            return null;
        
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
