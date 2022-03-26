/*
Time Complexity: O(N), N is the number of Nodes in the tree
Space Complexity: O(H), H is the height of the tree
Run on Leetcode: yes
Any difficulties: no

Approach:
1. Attempted after discussed in the class
 */
public class LowestCommonAncestorOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);

        if(left!= null && right!=null ){
            return root;
        }else if(left == null && right == null){
            return null;
        }else{
            return left == null ? right: left;
        }
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println("Lowest Common Ancestor: "+ lowestCommonAncestor(root, p, q).val);
    }
}
