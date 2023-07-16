// Time Complexity : O(log n) where n is the number of elements in the tree
// Space Complexity : O(log n) where n is the number of elements in the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

import java.util.ArrayList;
import java.util.List;

public class LCABinaryTree {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode node, TreeNode p, TreeNode q){
        if(node == null || node ==p || node ==q){
            return node;
        }

        TreeNode left = lca(node.left, p, q);
        TreeNode right = lca(node.right, p, q);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return node;
        }
    }

    //solution 2:
    private List<TreeNode> pathp;
    private List<TreeNode> pathq;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        this.pathp = new ArrayList<>();
        this.pathq = new ArrayList<>();

        backtrack(root, p, q, new ArrayList<>());
        for(int i=0; i<pathp.size(); i++){
            if(pathp.get(i) != pathq.get(i)){
                return pathp.get(i-1);
            }
        }
        return null;
    }

    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null){
            return;
        }

        path.add(root);
        if(root == p){
            pathp = new ArrayList<>(path);
            pathp.add(p);
        }
        if(root == q){
            pathq = new ArrayList<>(path);
            pathq.add(q);
        }

        if(pathp.size() == 0 || pathq.size() == 0){
            backtrack(root.left, p, q, path);
        }

        if(pathp.size() == 0 || pathq.size() == 0){
            backtrack(root.right, p, q, path);
        }

        path.remove(path.size()-1);

    }
}
