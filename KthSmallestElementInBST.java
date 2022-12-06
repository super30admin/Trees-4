
// TC : O(h+k)
// SC : O(h)

package S30_Codes.Trees_4;

// Definition for a binary tree node.

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

class KthSmallestElementInBST {
    int k;
    Integer ans;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        ans = null;

        DFS(root);
        return ans;
    }

    private void DFS(TreeNode root){
        if(root == null)
            return;

        DFS(root.left);
        k--;
        if(k == 0)
            ans = root.val;
        if(ans == null)
            DFS(root.right);

    }
}