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
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q,new ArrayList<>());
        
        for(int i=0;i<path1.size();i++){
            if(path1.get(i)==path2.get(i))
             continue;
             else
             return path1.get(i-1);
        }
        return root;
    }

    void helper(TreeNode root,TreeNode p,TreeNode q,List<TreeNode> path){
       if(root==null)
        return;
       path.add(root);
       if(p==root){
       path1=new ArrayList<>(path);
       path1.add(root);
       }
       if(q==root){
       path2= new ArrayList<>(path);
       path2.add(root);
       }

       

        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        path.remove(path.size()-1);
    }
}