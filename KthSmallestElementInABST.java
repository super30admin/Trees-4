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
// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Recursive
class Solution {
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result.val;
    }

    public void inorder(TreeNode root) {
        if(root == null) return;
        if(result == null)
            inorder(root.left);
        count--;
        if (count == 0) {
            result = root;
            return;
        }
        if(result == null)
            inorder(root.right);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Iterative
class Solution {
    Stack<TreeNode> st;
    TreeNode result;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        st = new Stack<>();
        inorder(root, k);
        return result.val;
    }

    public void inorder(TreeNode root, int k) {
        while(!st.isEmpty() || root != null) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k == 0){
                result = root;
                return;
            }
            root = root.right;
        }
    }
}

// Time Complexity : buildTree : O(n), get Kth smallest - O(log n)
// Space Complexity : O(n+h), where n is the space for creating a new Tree and h is SC for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach for follow up part - find kth smallest when insertion and deletion can happen
public class Solution {
    int cnt = 1;
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.count = cnt++;
        rootWithCount.right = buildTreeWithCount(root.right);
        return rootWithCount;
    }

    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if(rootWithCount.count == k) {
            return rootWithCount.val;
        } else if (rootWithCount.count > k) {
            return kthSmallest(rootWithCount.left, k);
        } else {
            return kthSmallest(rootWithCount.right, k);
        }
    }

    class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {val = x; count = 1;};
    }
}
