package s30.trees.trees4;

import s30.trees.TreeNode;


//ALGO: using BST feature.
// if p falls in left and q falls in right the current node is LCA

//TC: O(logn)
//SC: O(h)
public class LCABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }

        //base
        if(root.val >= p.val && root.val <=q.val){
            return root;
        }

        if(q.val < root.val) return lowestCommonAncestor(root.left, p,q);

        return lowestCommonAncestor(root.right, p,q);

    }
    public static void main(String[] args) {

    }
}
