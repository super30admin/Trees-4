// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.Stack;

// Your code here along with comments explaining your approach
// Approach 1: DFS - iterative
// Time Complexity :O(h+ k) = O((log n) + k) = O(k)
//      h: height of the tree
//      n: number of elements in tree
//      k: kth smallest element
// Space Complexity : O(h) = O(log n)
//      h: height of the tree
//      n: number of elements in tree
//Note: The tree is BST   
class Problem1S1 {
   
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** find kth smallest element */
    public int kthSmallest(TreeNode root, int k) {

        // stack
        Stack<TreeNode> s = new Stack<TreeNode>();

        // iterate left, root, right
        while(!s.isEmpty() || root!= null)
        {
            // go left
            while(root != null)
            {
                s.push(root);
                root = root.left;
            }
            // pop left most
            root = s.pop();
            k--;
            // check if k is 0
            if(k == 0)
                return root.val;
            // go right
            root = root.right;
        }
        // edge case
        return -1;
    }
}
// Your code here along with comments explaining your approach
// Approach 2: DFS - recursive
// Time Complexity :O(h+ k) = O((log n) + k) = O(k)
//      h: height of the tree
//      n: number of elements in tree
//      k: kth smallest element
// Space Complexity : O(h) = O(log n)
//      h: height of the tree
//      n: number of elements in tree
//   Recursive stack space
//Note: The tree is BST  
class Problem1S2 {
   
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // global
    int count;
    int result;

    /** find kth smallest element in tree */
    public int kthSmallest(TreeNode root, int k) {

        // default value
        result = -1;
        count = k;

        // do dfs
        depthFirst(root);

        // return result
        return result;
    }
    
    /** DFS travsersal */
    private void depthFirst(TreeNode root){
        // base case
        if(root == null)
            return;
        
        // go left
        depthFirst(root.left);

        // process root
        count--;
        if(count == 0){
            result = root.val;
            return;
        }
        // go right
        depthFirst(root.right);
        
    }
    
}