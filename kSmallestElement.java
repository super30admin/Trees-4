//DFS approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes
// Space Complexity :0(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    int result, count;  //I are declaring result to store the kth smallest index and count which is equal to k as it has to be a class variable. If it's a local variable, we might miss out on the 1st smalles element
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        count = k;
        result = -1;    //declaring to optimize so that once result is found, the recursive function does not need to call unnecessarily
        dfs(root, count);   //calling recursive function
        return result;  //returning result
    }
    public void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        if(result == -1){
            dfs(root.left, k);  //doing inorder traversal
        }
        count--;    //reducing count once base case is hit as root will be pointing to the smallest element then
        if(count == 0){ //if count becomes 0 that means we are at our desired index and store the value
            result = root.val;
        }
        if(result == -1){
            dfs(root.right, k);
        }
    }
}

//Iterative approach
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int result = 0;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if(k == 0){
                result = root.val;
            }
            root = root.right;
        }
        return result;
    }
}