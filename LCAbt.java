import java.util.*;
public class LCAbt {
    //Top down recursion with backtracking TC=O(h), SC=O(h)
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        helper(root,p,q,new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
            if(pathP.get(i)!=pathQ.get(i)){
                return pathP.get(i-1);
            }
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root==null)return;
        //logic
        //action:add to path
        path.add(root);
        if(root==p){
            pathP = new ArrayList<>(path);
            //to avoid finding the shorter list b/w pathP ang qPath, add curr root to both
            pathP.add(root);
        }
        if(root==q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //recurse
        helper(root.left,p,q,path);
        helper(root.right,p,q,path);
        //backtrack:
        path.remove(path.size()-1);

    }
}

//    //Bottop up recursion,child return left and right to parent
//    //TC = O(n) SC=O(h)
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null||root==p||root==q)return root;
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        if(left==null&&right==null)return null;
//        else if(left!=null&&right!=null)return root;
//        else if(left==null&&right!=null)return right;
//        else if(left!=null&&right==null)return left;
//        else return root;
//    }
