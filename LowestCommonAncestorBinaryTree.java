import java.util.ArrayList;
import java.util.List;

/*
backtracking TC-O(N) SC-O(h)

* */
public class LowestCommonAncestorBinaryTree {
    List<TreeNode> pathP;//SC-O(h)
    List<TreeNode> pathQ;//SC-O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pathP=new ArrayList<>();
        pathQ=new ArrayList<>();
        backtracking(root,p,q,new ArrayList<>());
        for(int i=0;i<pathP.size();i++){
            if(pathP.get(i)!=pathQ.get(i))
                return pathP.get(i-1);
        }
        return null;
    }

    public void backtracking(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root==null) return;
        //logic

        //action
        path.add(root);
        if(root==p){
            pathP=new ArrayList<>(path);
            pathP.add(p);
        }
        if(root==q){
            pathQ=new ArrayList<>(path);
            pathQ.add(q);
        }

        //recurse
        backtracking(root.left,p,q,path); //SC-O(h)
        backtracking(root.right,p,q,path); //SC-O(h)

        //backtrack
        path.remove(path.size()-1);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
/*
//recursion TC- O(N)   SC- O(h)
 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }else if(right ==null){
            return left;
        }else{
            return root;
        }

    }
* */