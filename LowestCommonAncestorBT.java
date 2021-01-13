// Time Complexity : O(n) 
// Space Complexity :O(h) h - height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: find the path of traversal for each given nodes and then check both the paths
// and return the previous node where they are different. 
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
        if(root==null)
            return null;
        List<TreeNode> path1 = new ArrayList();
        List<TreeNode> path2 = new ArrayList();
        helper(root,p,path1);
        helper(root,q,path2);
        int i;
        for(i=0;i<Math.min(path1.size(),path2.size());i++){
            if(path1.get(i)!=path2.get(i))
                break;
        }
        return path1.get(i-1);
    }
    private void helper(TreeNode root,TreeNode p, List<TreeNode> path){
        if(root==null)
            return;
        
        //System.out.println(path.size()+" pavalue "+root.val);
        path.add(root);
        if(root==p)
            return;
        helper(root.left,p,path);
        if(path.get(path.size()-1)==p)
            return;
        helper(root.right,p,path);
        if(path.get(path.size()-1)==p)
            return;
        
            path.remove(path.size()-1);
    }
}