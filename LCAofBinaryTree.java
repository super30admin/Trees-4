/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Find the paths for the nodes p and q. Then find the common node from them
// TC: O(n)
// SC: O(h)s
class LCAofBinaryTree {
    List<Integer> pathP;
    List<Integer> pathQ;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathP = new ArrayList<>();
        this.pathQ = new ArrayList<>();
        helper(root,p,pathP);
        helper(root,q,pathQ);
        System.out.println(pathP);
        System.out.println(pathQ);
        int i = 0;
        for (; i < pathP.size() && i < pathQ.size(); i++) {
            if (!pathP.get(i).equals(pathQ.get(i))) {
                break;
            }
        }
        return new TreeNode(pathP.get(i - 1));
    }
    private boolean helper(TreeNode root, TreeNode target, List<Integer> path) {
        if(root == null) return false;
        path.add(root.val);
        if(root.val == target.val) {
            return true;
        }
        if(helper(root.left,target,path) || helper(root.right,target,path)) {
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}


//Solution without using any space for paths
// TC : O(n)
// SC: O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root,p,q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = helper(root.left,p,q);
        TreeNode right = helper(root.right,p,q);
        if(left == null && right == null) return null;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return root;
    }
}
