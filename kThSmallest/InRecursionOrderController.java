package kThSmallest;

// TC: O(k + logN)
// SC: O(1)

//to save some recursive calls  use a flag

class InRecursionOrderController {
    int result;
    int count;
    boolean flag;

    public int kthSmallest(TreeNode root, int k) {

        this.count = k;
        inorder(root);
        this.flag = false;

        return result;
    }

    private void inorder(TreeNode root)
    {
        // base
        if(root == null) {
            return;
        }

        System.out.println(root.val);

        // logic
        inorder(root.left);
        count--;

        if(count == 0) {
            result = root.val;
            this.flag  = true;
        }

        if(!this.flag) {
            inorder(root.right);
        }
    }
}