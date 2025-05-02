import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* 
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null){
            return null;
        }if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            return left;
        }else{
            return root;
        }
    }
}
*/
//Tc O(n)
//SC: O(h)
class LCAofBT {
    List<TreeNode> pathp=new ArrayList<>();
    List<TreeNode> pathq=new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p ||root==q){
            return root;
        }
        
        List<TreeNode> path=new ArrayList<>();
        backtrack(root,p,q,path);
        for(int i=0;i<pathp.size();i++){
            if(pathp.get(i)!=pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
    }
    //preorder
    /*
    private void backtrack( TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        //base
        if(root==null){
            return;
        }

        //logic
        path.add(root);
        if(root==p){
            pathp=new ArrayList<>(path);
            pathp.add(root);
            //return;
        }
        if(root==q){
            pathq=new ArrayList<>(path);
            pathq.add(root);
           // return;
        }
        
        backtrack(root.left,p,q,path);
        backtrack(root.right,p,q,path);
        path.remove(path.size()-1);
    }
    */
    //inorder
    private void backtrack( TreeNode root, TreeNode p, TreeNode q,List<TreeNode> path){
        //base
        if(root==null){
            return;
        }

        //logic
        path.add(root);
        
        backtrack(root.left,p,q,path);
        if(root==p){
            pathp=new ArrayList<>(path);
            pathp.add(root);
            //return;
        }
        if(root==q){
            pathq=new ArrayList<>(path);
            pathq.add(root);
           // return;
        }
        backtrack(root.right,p,q,path);
        path.remove(path.size()-1);
    }
    
}
