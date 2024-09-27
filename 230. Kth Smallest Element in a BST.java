// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach: 

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}