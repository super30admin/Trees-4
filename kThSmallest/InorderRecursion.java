package kThSmallest;


//This is conditional inorder traversal, when we reach k=0 then returning.
// Time Complexity : O(n) n is the number of nodes.
// Space Complexity : O(h) recursive stack space.


class InorderRecursion {
    int result;
    int count;

    public int kthSmallest(TreeNode root, int k) {

        this.count = k;
        inorder(root);

        return result;
    }

    private void inorder(TreeNode root)
    {
        // base
        if(root == null) {
            return;
        }

        // logic
        inorder(root.left);
        count--;

        if(count == 0) {
            result = root.val;
        }

        inorder(root.right);

    }
}

