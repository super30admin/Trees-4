import java.util.ArrayList;
import java.util.List;

public class LCAofBinaryTree {
    List<TreeNode> pt; //To store the path of p
    List<TreeNode> qt; //To store the path of q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { //O(n) T.C, O(h) S.C
        this.pt = new ArrayList<>();
        this.qt = new ArrayList<>();
        recursion(root, p, q, new ArrayList<>());

        for(int i=0; i<pt.size(); i++) { //sliding window on pt and qt
            if(pt.get(i) != qt.get(i)) //whenever there is a new node in the path
                return pt.get(i-1); //the previous path is the LCA
        }
        return null;
    }

    private void recursion(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        //base
        if(root == null) return;

        //logic
        //action
        path.add(root);

        //recurse
        recursion(root.left, p, q, path);

        if(root == p) { //if the current root is p
            pt = new ArrayList<>(path); //make a deep copy of path and assign it to pt
            pt.add(root); //add an extra dummy variable of the root into the pt to cater for array out of bounds
        }
        if(root == q) { //same as above for q
            qt = new ArrayList<>(path);
            qt.add(root);
        }

        if(pt.isEmpty() || qt.isEmpty()) { //conditional recursion, continue only if both nodes are not found on left
            recursion(root.right, p, q, path);
        }

        //backtrack
        path.removeLast();
    }

    public TreeNode lowestCommonAncestorDFS(TreeNode root, TreeNode p, TreeNode q) { //O(n) T.C, O(h) S.C
        if(root == null || root == p || root == q) return root; //if either p or q is found, that is the valid answer

        TreeNode left = lowestCommonAncestorDFS(root.left, p, q); //perform left recursion
        TreeNode right = lowestCommonAncestorDFS(root.right, p, q); //perform right recursion

        if(left != null && right != null) return root; //if both children are not null, return root
        else if(left != null) return left; //if the left is not null, return left recursion
        else return right; //otherwise, return right recursion
    }

    public static void main(String[] args) {
        // Constructing the following binary tree (not a BST)
        //        17
        //       /  \
        //      7   15
        //     / \    \
        //    3   30   20
        //   / \
        //  10  5

        TreeNode root = new TreeNode(17);
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node30 = new TreeNode(30);
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node20 = new TreeNode(20);

        root.left = node7;
        root.right = node15;
        node7.left = node3;
        node7.right = node30;
        node3.left = node10;
        node3.right = node5;
        node15.right = node20;

        LCAofBinaryTree lcAofBinaryTree = new LCAofBinaryTree();

        // Test case 1: LCA of 10 and 5 is 3
        TreeNode lca1 = lcAofBinaryTree.lowestCommonAncestor(root, node10, node5);
        System.out.println("LCA of 10 and 5 is: " + lca1.val);

        // Test case 2: LCA of 10 and 30 is 7
        TreeNode lca2 = lcAofBinaryTree.lowestCommonAncestor(root, node10, node30);
        System.out.println("LCA of 10 and 30 is: " + lca2.val);

        // Test case 3: LCA of 7 and 20 is 17
        TreeNode lca3 = lcAofBinaryTree.lowestCommonAncestorDFS(root, node7, node20);
        System.out.println("LCA of 7 and 20 using DFS is: " + lca3.val);

        // Test case 4: LCA of 3 and 15 is 17
        TreeNode lca4 = lcAofBinaryTree.lowestCommonAncestorDFS(root, node3, node15);
        System.out.println("LCA of 3 and 15 using DFS is: " + lca4.val);
    }
}
