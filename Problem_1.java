// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//go to the leftmost i.e. smallest element and do inorder traversal with increasing count with each node
//return the value when count is equal to k

//230. Kth Smallest Element in a BST
class Solution {
    int count;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            count++;
            if(count == k){
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }
    
}

//Recursive Method
// class Solution {
//     int result;
//     int count;
//     public int kthSmallest(TreeNode root, int k) {
//         if(root == null) return 0;
//         result = 0;
//         dfs(root, k);
//         return result;
//     }
//     private void dfs(TreeNode root, int k){
//         if(root == null) return;
        
//         dfs(root.left, k);
//         count ++;
//         if(count == k){
//             result = root.val;
//             return;
//         }
//         dfs(root.right, k);
//     } 
// }
