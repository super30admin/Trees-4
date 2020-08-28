/**
 Time : O(n)
 Space: O(1)
 Run on LeetCode: yes.
 */
class Solution {
    int num;
    private int inorder(TreeNode node){
        if(node == null)
            return 0;

        //get left val, return left if num == 0
        int left = inorder(node.left);
        if(num == 0)
            return left;

        //reduce num, return val if num == 0
        num--;
        int val = node.val;
        if(num == 0)
            return val;

        //get right val, return right if num == 0
        int right = inorder(node.right);
        if(num == 0)
            return right;

        return val;
    }
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        return inorder(root);
    }
}
