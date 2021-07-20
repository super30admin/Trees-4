package Trees4;

import java.util.ArrayList;
import java.util.List;

public class question103_LowestCommonAncestorOfBinaryTree {
    /* Created by palak on 7/19/2021 */

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
        TC: O(n)
        SC: O(h) (Backtracking)
    */
    List<TreeNode> path1;
    List<TreeNode> path2;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        backtrack(root, p, q, new ArrayList<>());
        for(int i = 0; i < path1.size() ; i++) {
            if(path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return null;
    }
    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //Base
        if(root == null) return;
        if(root == p) {
            path1 = new ArrayList<>(path);
            path1.add(p); path1.add(p);
        }
        if(root == q) {
            path2 = new ArrayList<>(path);
            path2.add(q); path2.add(q);
        }
        //Logic
        //Action
        path.add(root);
        //Recurse
        backtrack(root.left, p, q, path);
        backtrack(root.right, p, q, path);
        //Backtrack
        path.remove(path.size() - 1);
    }

    /*
        TC: O(n)
        SC: O(h) (Backtracking)
    */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if(left != null && right != null)   return root;
        else if(left != null)   return left;
        else if(right != null)  return right;
        else return null;
    }

    public static void main(String[] args) {

    }
}