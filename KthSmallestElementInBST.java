// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes.
// Any problem you faced while coding this :Nope.


// Your code here along with comments explaining your approach
class KthSmallestElementInBST {
    TreeNode kthSmallest = null;
    int K = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(null == root){
            return Integer.MAX_VALUE;
        }
        inorder(root,k);
        return kthSmallest.val;
    }
    public void inorder(TreeNode root, int k){
        if(null == root){return;}
        inorder(root.left,k);
        K++;
        if(k == K){kthSmallest = root;return;}
        inorder(root.right,k);
    }
}