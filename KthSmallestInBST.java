// Time Complexity : O(N)
// Space Complexity : O(N), stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
Inorder traversal and add to stack. Remove from stack and return the Kth element.
*/



public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while (true) {
            while(root != null) {
            stack.add(root);
            root = root.left;
            }
            root  = stack.removeLast();
            k--;
            if(k == 0)
                return root.val;
            root = root.right;
        }
    
        //return -1;
    }
}
