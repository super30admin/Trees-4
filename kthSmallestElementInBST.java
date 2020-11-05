// Time Complexity : O(n), form inorder
// Space Complexity : O(log n), stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// store inorder traversal and return k-1 th element

class Solution {
    List<Integer> inorder;
    
    private void populateInorder(TreeNode node){
        if(node.left!=null){
            populateInorder(node.left);
        }
        inorder.add(node.val);
        if(node.right!=null){
            populateInorder(node.right);
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        inorder = new LinkedList();
        
        populateInorder(root);
    
        return inorder.get(k-1);
    }
}