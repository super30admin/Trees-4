/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(N)
    N - Total nodes
* 
* Space Complexity: O(H)
    H - Height of the tree
* 
*/

public class KthSmallest {
    int count;

    int kthSmallest;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallest = -1;

        inorder(root);

        return kthSmallest;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        count--;

        if (count == 0) {
            kthSmallest = root.val;
        }

        if (kthSmallest == -1) {
            inorder(root.right);
        }
    }
}