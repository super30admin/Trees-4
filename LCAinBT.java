import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// TC: O(n) as all the nodes are touched
// SC: O(n) as Lists are used for storing the lists
public class LCAinBT {
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
        System.out.println(LCA(root, root.right.left, root.left.right.right).val); // 3
    }

    static List<TreeNode> listP;
    static List<TreeNode> listQ;

    private static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        listP = new ArrayList<>();
        listQ = new ArrayList<>();
        dfs(root, p, q, new ArrayList<>());
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i) != listQ.get(i)) {
                return listP.get(i - 1);
            }
        }
        return root;
    }

    private static void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        // base
        if (root == null)
            return;

        // logic
        // action
        path.add(root);
        if (root == p) {
            listP = new ArrayList<>(path);
            listP.add(p);
        }
        if (root == q) {
            listQ = new ArrayList<>(path);
            listQ.add(q);
        }
        // recurse
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        // unaction
        path.remove(path.size() - 1);
    }
}
