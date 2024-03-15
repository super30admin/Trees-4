//TC: O(n)
//SC: O(h)
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
       // this.pathp=new ArrayList<>();
      //  this.pathq=new ArrayList<>();
      helper(root,p,q,new ArrayList<>());
      for(int i=0;i<pathp.size();i++)
      {
        if(pathp.get(i)!=pathq.get(i))
        {
            return pathp.get(i-1);
        }
      }
return null;
        
    }
    private  void helper(TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path)
    {
        if(root==null)return;
        path.add(root);
        if(root==p)
        {
             
            pathp=new ArrayList<>(path);
         pathp.add(root);

        }
         if(root==q)
        {
            pathq=new ArrayList<>(path);
            pathq.add(root);

        }


        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}