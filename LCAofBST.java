/*
Intuition is that in a BST, when the values are on the either side of a node, that node is the lCA.
 */
public class LCAofBST { //O(h) T.C, O(h) S.C
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) { //if both values are on left side of root
            return lowestCommonAncestor(root.left, p, q); //run the recursion of its left child
        }
        else if(p.val > root.val && q.val > root.val) { //if both values are on right side
            return lowestCommonAncestor(root.right, p, q); //run recursion on right child
        }
        else { //if either root is one of p,q or if p and q are on either side of root, return root
            return root;
        }
    }

    public static void main(String[] args) {
        // Constructing the following BST
        //        20
        //       /  \
        //      10  30
        //     /  \
        //    5   15
        //   / \    \
        //  3   7    17

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(17);

        // Test case 1: LCA of 3 and 7 is 5
        TreeNode lca1 = lowestCommonAncestor(root, new TreeNode(3), new TreeNode(7));
        System.out.println("LCA of 3 and 7 is: " + lca1.val);

        // Test case 2: LCA of 5 and 15 is 10
        TreeNode lca2 = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(15));
        System.out.println("LCA of 5 and 15 is: " + lca2.val);

        // Test case 3: LCA of 7 and 17 is 10
        TreeNode lca3 = lowestCommonAncestor(root, new TreeNode(7), new TreeNode(17));
        System.out.println("LCA of 7 and 17 is: " + lca3.val);

        // Test case 4: LCA of 10 and 7 is 10
        TreeNode lca4 = lowestCommonAncestor(root, new TreeNode(10), new TreeNode(7));
        System.out.println("LCA of 10 and 30 is: " + lca4.val);
    }
}
