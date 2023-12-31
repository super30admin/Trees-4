//Time Complexity:O(n)
//Space complexity:O(h), h-height of tree

//
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
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       
        helper(root,p,q,new ArrayList<>());

        for(int i =0;i<pathP.size();i++){
            if(pathP.get(i)!=pathQ.get(i))
                return pathP.get(i-1);
        }
        return null;
    }
    private void helper(TreeNode root,TreeNode p,TreeNode q,List<TreeNode> path){

        //base case

        if(root==null) return;

        if(pathP!=null && pathQ != null) return;
        //action
        path.add(root);

        //logic
        if(root==p){
            pathP = new ArrayList<>(path);
            pathP.add(p);
        }
        if(root==q){
            pathQ = new ArrayList<>(path);
            pathQ.add(q);
        }
        //recurse

        helper(root.left,p,q,path);
         helper(root.right,p,q,path);

         //undo
         path.remove(path.size()-1);

    }
}