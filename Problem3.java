// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Problem3 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();

        map.put(root, null);
        queue.add(root);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                map.put(temp.left, temp);
                queue.add(temp.left);
            }

            if (temp.right != null) {
                map.put(temp.right, temp);
                queue.add(temp.right);
            }
        }

        HashSet<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }

        while (!ancestors.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}