// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Recursion and InOrder traverse and store in a List
// So the elment k-1 is the smallest k
class Solution {
    
    private List<Integer> list = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) { 
        helper(root);
        return list.get(k-1);
    }
    
    private void helper(TreeNode root){
        if(root == null){
            return;
        } 
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
