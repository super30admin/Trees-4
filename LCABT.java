package s30.trees.trees4;

import s30.trees.TreeNode;


//ALGO: Each node should Identify if there is an element in the left tree and in the right tree then that node is LCA
// Exception case, a node can be its descendant, as we know all are unique & p,q will exist in the tree. we can assign LCA when we find a node
// then search if the other exists in the other part of tree if No, it should exist in the subtree of matched node.

//TC: O(n)
//SC: O(h)
public class LCABT {
    TreeNode ans;
    TreeNode p,q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.p = p;
        this.q = q;
        lca(root);

        return ans;

    }


    private boolean lca(TreeNode node){

        if(node == null){
            return false;
        }

        if(node.val == p.val || node.val == q.val){
            ans = node;
            return true;
        }

        boolean left = lca(node.left);
        boolean right = lca(node.right);

        if(left && right){
            ans = node;
        }

        return left || right;

    }
    public static void main(String[] args) {

    }
}
