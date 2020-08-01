// Time Complexity : O(n)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :




//Iterative using Stack : Inorder traversal
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //create a stack of treeNode
        Stack<TreeNode> st = new Stack<>();
        //do till stack empty and root = null
        while(!st.isEmpty() || root != null) {
            //add all nodes on left
            //if root != null
            //add root to stack
            //and go to left node
            while(root != null) {
                st.push(root);
                root = root.left;          
            }
            //if null reached on left
            //pop top of stack (let root point to it, to go to right side)
            root = st.pop();
            //decrease k value
            k--;
            //check if k = 0, if k = 0, popped node is kth smallest
            if(k == 0) {
                return root.val;
            }
            //go to right side (root = right) (no traverse this sub tree)
            root = root.right; 
        }
        //if kth smallest node, not present, return -1 (wont reach this case as k is always valid)
        return -1;
    }
}


//////////////////////////

// Time Complexity : O(n)
// Space Complexity : O(logn) (stack size)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//Recursive : Inorder traversal
class Solution {
    //declare kcount (keep count of k) and result
    int kcount;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        //initialize kcount and result
        kcount = k;
        result = -1;
        //call helper function on root
        helper(root);
        //return the result
        return result;
    }
    
    private void helper(TreeNode root) {
        //base case : if root = null, return the method
        if(root == null) return;
        //logic
        //call recursively on left side
        helper(root.left);
        //once all nodes of left are added
        //in stack : st.pop() operation takes place
        //so decrease kcount
        kcount--;
        //check if k nodes have been popped
        //and so, set result to root.val and return
        if(kcount == 0) {
            result = root.val;
            return;
        }
        //else call right node
        helper(root.right);
    }
}


