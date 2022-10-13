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
    //tc - o(n)
    //sc- o(h) o(h)stack space and max o(h) size of list used
    List<TreeNode> pathp;
    List<TreeNode> pathq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null) return null;
      helper(root,p,q,new ArrayList<>());

      for(int i=0;i<pathq.size();i++)
      {
       if(pathp.get(i) != pathq.get(i))
       {
           return pathp.get(i-1);
       }
      }
       return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path)
    {
        //base case
        if(root == null) return;
      //action
        path.add(root);
        if(root == p)
        { // here we are adding target node again to the path so that while comparing if both the list are not equal we can return prev ele, hence we move action step to top
            pathp = new ArrayList<>(path);
            pathp.add(root);
        }
         if(root == q)
        {
            pathq = new ArrayList<>(path);
            pathq.add(root);
        }
        //logic
  
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        //backtrack
        path.remove(path.size()-1);
    }
}