import java.util.*;

public class LowestCommonAncestorInBT {
    List<TreeNode> pathQ;
    List<TreeNode> pathP;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TC:O(n)
        // SC:O(h)+O(h)

        helper(root, p, q, new ArrayList<>());
        for(int i = 0; i < pathQ.size(); i++){
            if(pathQ.get(i) != pathP.get(i))
                return pathP.get(i-1);
        }
        return null;
    }
    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;
        if(pathP != null && pathQ != null) return; //comditional recursion
        //action
        path.add(root);
        //logic
        if(root == p){
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q){
            pathQ = new ArrayList<>(path);
            pathQ.add(root);
        }
        //recurse
        helper(root.left, p, q, path);
        helper(root.right, p, q, path);
        //backtrack
        path.remove(path.size()-1);

    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //without extra space for path
//        TC:O(n)
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p , q);
        TreeNode right = lowestCommonAncestor2(root.right, p , q);
        if(left == null && right == null)
            return null;
        else if(left == null && right != null)
            return right;
        else if( right == null && left != null)
            return left;
        else
            return root;

    }
}
