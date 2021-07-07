/*
=================================  Brute-force approach ==========================================
Time: O(N) where N is number of nodes
Space: O(N) for array
Algorithm:
=========
1. Traverse in-order through the tree and store elements in list
2. Return (k-1)th element of list at the end (kth smallest)
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        kthSmallest(result, root, k);
        return result.get(k-1);
    }
    
    private void kthSmallest(List<Integer> result, TreeNode root, int k) {
        if(root == null)
            return;
        kthSmallest(result, root.left, k);
        result.add(root.val);
        kthSmallest(result, root.right, k);
    }
}

/*
================================= Recursive approach ==========================================
Time: O(H) where H is the height of the tree
Space: O(1) auxilliary and O(H) recursive stack space
Approach: 
========
1. Instead of using additional space to store all elements, stop traversing once kth element is reached
2. Keep track of count in a class variable and decrement so that when it reaches 0, we have our kth node
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count;
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        count = k;
        helper(root);
        return result.val;
    }
    
    private void helper(TreeNode root) {
        // base case
        if(root == null) 
            return; 
        //logic
        helper(root.left);              // traverse till left most node and process left subtree first
        if(--count == 0) {
            result = root;              // process root
            return;
        }
        helper(root.right);             // process right if kth element is not yet found
        
    }
    
    
}


/*
================================= Iterative approach ==========================================
Time: O(H) where H is the height of the tree
Space: O(H) auxilliary space
Approach: 
========
1. Instead of using additional space to store all elements, stop traversing once kth element is reached
2. Keep track of elements in stack and decrement so that when it reaches 0, we have our kth node
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        // initialize stack
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root.left;
        
        while(true) {
            
            //push left subtree's left nodes to stack till null
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        
            // pop from stack
            curr = stack.pop();
            // check if it is kth smallest element
            if(--k == 0) 
                return curr.val;
            // if not yet found, traverse right subtree till kth element is found
            curr = curr.right;
        }
    }
    
    
}