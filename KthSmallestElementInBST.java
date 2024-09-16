/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Brute force: do inoder traversal iteratively using stack that will give us a sorted array so kth smallest element would be the element at k-1 th position in an array
*/

class Solution {
    private class Wrapper{
        int result;
        int k;
        public Wrapper(int k){
            this.k = k;
            this.result = 0;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        //return kthSmallestIterative(root, k);
        //to avoid using global variable and passing reference to recursive function 
        Wrapper wp = new Wrapper(k);
        kthSmallestIterativeRecursive(root, wp);
        return wp.result;
    }
    
/*Optimized Approach: I could speed up the solution as there is no need to build entire inorder traversal. I can
stop when we find the kth element.  when we start inorder traversal we start from the smallest element in the tree.
Time Complexity: O(h+k)
Space complexity: O(H) where is H is the height of binary tree.*/
    private int kthSmallestIterative(TreeNode root, int k){
        //edge case
        if(root ==null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur =  stack.pop();
            if(--k == 0)
                return cur.val;
            cur = cur.right;
        }
        return -1;
    }
    //resursive approach:time complexity would be same as iterative approach
    private void kthSmallestIterativeRecursive(TreeNode root, Wrapper wp){
        //base case
        if(root == null) 
            return;
        //doing inorder traversal
        //left traversal
        kthSmallestIterativeRecursive(root.left, wp);
        //logic,
        if(--wp.k == 0) 
            wp.result = root.val;
        //right traversal
        kthSmallestIterativeRecursive(root.right, wp);
    }
    
}
