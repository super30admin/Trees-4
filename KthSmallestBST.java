/**
 * Time Complexity: O(n) where n = number of nodes
 * Space Complexity : O(h) where h = height of the tree
 */
public class KthSmallestBST{
    int count;
    int answer;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return answer;
    }

    public void inOrder(TreeNode root)
    {
        if(root == null) return;
        inOrder(root.left);
        count--;
        if(count == 0)
        {
            answer = root.val;
            return;
        }
        inOrder(root.right);

    }
}

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