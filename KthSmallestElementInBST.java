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

Optimized Approach: I could speed up the solution as there is no need to build entire inorder traversal. I can stop when we find the kth element. 
3. when we start inorder traversal we start from the smallest element in the tree.
Time Complexity: O(h+k)
Space complexity: O(H) where is H is the height of binary tree.
*/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //edge case
        if(root ==null)
            return -1;
        
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
}
