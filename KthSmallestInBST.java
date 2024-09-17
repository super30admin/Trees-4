
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// inorder Traverse the BST to get elements in ascending order
// maintain counter and return kth element

class Solution {
    int i = 0; int kth = -1;
    Boolean flag = false;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        kthSmallest(root.left, k);
        //process
        i++;
        if(i==k) {
            kth = root.val;
            flag = true;
        }
        if(!flag)
            kthSmallest(root.right, k);

        return kth;
    }
}