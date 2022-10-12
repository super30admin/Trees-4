// Time Complexity : O(n)
// Space Complexity :O(h)
// n is the number of nodes in the tree
// h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Approach 1 - Top Down Approach
// Time Complexity : O(n)
// Space Complexity :O(h)
// n is the number of nodes in the tree
// h is the height of the tree

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
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //null check
        if(root == null) return null;

        helper(root,p,q,new ArrayList<>());

        for(int i = 0 ; i < pathp.size() ; i++){
            if(pathp.get(i) != pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
    }

    private void helper(TreeNode root, TreeNode p , TreeNode q, List<TreeNode> path){

        //base
        if(root == null)
            return;


        //logic
        //action
        path.add(root);

        if(root == p){
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }
        if(root == q){
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }

        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);

        //backtrack
        path.remove(path.size()-1);
    }
}

n //Approach 1 - Bottom Up Approach
// Time Complexity : O(n)
// Space Complexity :O(h)
// n is the number of nodes in the tree
// h is the height of the tree
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

        if(root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left == null && right == null)
            return null;

        else if(left == null && right != null)
            return right;

        else if(left != null && right == null)
            return left;

        else
            //left != null && right != null
            return root;
    }
}