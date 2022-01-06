// Time Complexity : O(h + k)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root != null ) { stack.push(root); root = root.left;}
            TreeNode top = stack.pop();
            k--;
            if(k == 0) return top.val;
            root = top.right;
        }
        return -1;
    }
}