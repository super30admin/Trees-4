// Time Complexity : O(h+k)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Do a inorder traversal till k values
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        
        Stack<TreeNode> s = new Stack();
        
        while(!s.isEmpty() || root!=null) {
            
            while(root!=null) {
                
                s.add(root);
                root=root.left;
                
            }
            root = s.pop();
            k--;
            if(k==0) return root.val;
            
            root=root.right;
              
        }
        return -1;
    }
}
