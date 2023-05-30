//Leetcode - 230
//TimeComplexity - O(N)
//Space Complexity - O(H)
public class KthSmallestElementInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        //base
        if(root == null) return;
        //logic
        if(!flag)
            inorder(root.left);
        count--;
        if(count == 0)  {
            flag = true;
            result = root.val;
            return;
        }
        if(!flag)
            inorder(root.right);
    }
}
