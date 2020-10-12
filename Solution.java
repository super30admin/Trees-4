// Time Complexity : O(N) As we will go through each node in the BST
// Space Complexity : O(N) As we are creating a arraylist containing the values
//                      of all the nodes in BST
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// I am creating an arraylist consisting of all the nodes from the BST by performing an inorder traversal
// and then I will be returning the element at k - 1 position in the arraylist

class Solution {
    private List<Integer> inOrder(TreeNode root, List<Integer> arr){
        if(root == null) return arr;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
        return arr;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = inOrder(root, new List<Integer>());
        return result.get(k - 1);
    }
}
