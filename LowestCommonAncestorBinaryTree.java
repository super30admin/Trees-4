import java.util.ArrayList;
import java.util.List;

//Leetcode - 236
//TimeComplexity - O(H)
//Space Complexity - O(H)
public class LowestCommonAncestorBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base
        if(root == null || root == p || root == q) return root;
        //logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
            return null;
        } else if(left !=null && right == null) {
            return left;
        } else if(left == null && right != null) {
            return right;
        } else return root;
    }


    //O(H), and extra space for both lists
        /*List<TreeNode> pathP;
        List<TreeNode> pathQ;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            backtrack(root, p, q, new ArrayList<>());
            for(int i=0;i<pathP.size();i++) {
                if(pathP.get(i) != pathQ.get(i)) {
                    return pathP.get(i-1);
                }
            }
            return null;
        }
        public void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
            //base
            if(root == null) return;
            //logic
            path.add(root);
            if(root == p) {
                pathP = new ArrayList<>(path);
                pathP.add(p);//Adding a duplicate p node
            }
            if(root == q) {
                pathQ = new ArrayList<>(path);
                pathQ.add(q);//Adding a duplicate q node
            }
            //recurse
            backtrack(root.left, p, q, path);
            backtrack(root.right, p, q, path);
            //backtrack
            path.remove(path.size()-1);
        }*/
}
