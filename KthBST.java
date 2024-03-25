// Time Complexity : O(n),number of nodes.
// Space Complexity : O(h),  recursive stack space.
//where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do an inorder traversal and keep track of the kth element coming out stack that will be the kth smallest element

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
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        //when the element comes out of stack, decrease k.
        if(--count == 0){
           result = root.val;
           return;
        }

        inorder(root.right);
    }
}

// Iterative - inorder using Explicit stack 

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.isEmpty()){
            //all left elements in Stack
            while(root != null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            k--;
            if(k == 0){
                return root.val;
            }
            root = root.right;
        }

        return 0;// dummy
    }
}

//Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

// We can maintain a left count at each node and at times of insertion and deletion we can update the left count accordingly if they are being affected. To find the kth element we can discard
//half of tree based on the left count.

//Insertion , deletion and finding kth element can be done in log(n)