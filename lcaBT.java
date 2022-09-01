// approch 1 
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {

    // approch 1 using path and compare the path
    private static List<TreeNode> path1;
    private static List<TreeNode> path2;

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // null case

        if (root == null)
            return null;
        // intialize the paths
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();

        // dfs traversal and getting the path to reach to the
        // p and q
        dfs(root, p, q, new ArrayList<>());
        // check the path whenever we found mis match
        // we return last matched node
        // as it is our last ancestor
        for (int i = 0; i < path1.size(); i++) {
            if (path1.get(i).val != path2.get(i).val)
                return path1.get(i - 1);
        }

        return null;
    }

    private static void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base case
        if (root == null)
            return;

        // main logic
        // action
        // add root node to path
        path.add(root);
        if (root.val == p.val) {
            path1 = new ArrayList<>(path);
            // add extra variables
            path1.add(root);
        }
        if (root.val == q.val) {
            path2 = new ArrayList<>(path);
            // add extra node
            path2.add(root);
        }

        // recurse
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        // backtrack
        path.remove(path.size() - 1);

    }

    // approch 2 using two pointer
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root.val == p.val || root.val == q.val)
            return root;

        // main logic
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        // four cases
        if (left == null && right == null)
            return null;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return root;
    }

    public static void main(String[] args) {

    }
}