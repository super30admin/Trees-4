// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: we do the inorder traversal and increase the counter everytime the recursion is call for every level when count vaiable reaches k then it returns value of root. 

class Solution {
    int result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }
    private void inorder(TreeNode root, int k){
        if (root == null) return;
        inorder(root.left,k);
        count++;
        if(k == count){
            result = root.val;
        }
        inorder(root.right, k);
    }
}