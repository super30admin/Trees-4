// Time Complexity : O(n) where n = no of pixels i.e. rows * columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - DFS traversal from root.
//   - If current node is p or q, return node.
//   - Recurse left and right; if both return non-null → current node is LCA.
//   - If only one side is non-null → propagate that node up.
//   - If both sides null → return null (no match in subtree).


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LowestCommonAncestorBT {
    // List<TreeNode> pathP;
    // List<TreeNode> pathQ;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     helper(root, p, q, new ArrayList<>());
    //     for(int i = 0; i < pathP.size(); i++) {
    //         if(pathP.get(i) != pathQ.get(i)) {
    //             return pathP.get(i - 1);    //for 6 and 4, 3-5-6-6 and 3-5-2-4-4, so when mismatch happens node before it is ans
    //         }
    //     }

    //     return null;
    // }

    // private void helper(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> path) {
    //     if(root == null) {
    //         return;
    //     }

    //     path.add(root);

    //     if(root == p) {
    //         pathP = new ArrayList<>(path);
    //         path.add(root); //adding again for handling p and q are parent child edge case
    //     }

    //     if(root == q) {
    //         pathQ = new ArrayList<>(path);
    //         path.add(root);
    //     }

    //     helper(root.left, p, q, path);

    //     helper(root.right, p, q, path);

    //     path.remove(path.size() - 1);   //backtrack when reached leaf and p and q not found
    // }

    //TC = O(n) SC = O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) {
            return null;
        } else if(left != null && right == null) {
            return left;
        } else if(left == null && right != null) {
            return right;
        } else {
            return root;
        }

        //we return non null child we dont care if it is p || q || root
        //even for case 5 and 4, we return 5, from lvl 1 itself, then it traverses right subtree and returns null from all cases, then as ans we return non-null value between left and right i.e. 5.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        LowestCommonAncestorBT lcaSolver = new LowestCommonAncestorBT();
        TreeNode lca = lcaSolver.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        // Expected output: 5
    }
}
