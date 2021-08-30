//Time complexity: O(N), where N is the number of nodes.
//Space complexity: O(H), where H is the maximum height of the tree.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
 
class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val; 
        while (root != null) {
            int val = root.val;

            if (pVal > val && qVal > val) {
                root = root.right;
            } else if (pVal < val && qVal < val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
        
    }
}