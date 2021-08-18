// Time Complexity : O(n), n -> Number of nodes in the tree
// Space Complexity : O(log n), log n -> Height of Tree
class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        //return count;
    }
    
    private void inorder(TreeNode root, int k) {
        if(root == null) return;
        
        inorder(root.left, k);
        count++;
        System.out.println("count is " + count);
        if(count == k) {
            System.out.println("inside count is " + count);
            return root.val;
        }
        inorder(root.right, k);
    }
}