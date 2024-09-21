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

// Inorder traversal and return k-1th element of it
// TC - O(n)
// SC - O(n)
class KthSmallestElementInBST {
    List<TreeNode> result;
    public int kthSmallest(TreeNode root, int k) {
        this.result = new ArrayList<>();
        helper(root);
        return result.get(k-1).val;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        result.add(root);
        helper(root.right);
    }
}


// Maintain a max-heap of size k and whenever size > k, remove smallest element.
// Finally return the peek value in heap
// TC: O(n log k)
// SC: O(k+n) Priority Queue size - k, Recursive stack in worst case - n
class Solution {
    PriorityQueue<Integer> pq;
    public int kthSmallest(TreeNode root, int k) {
        this.pq = new PriorityQueue<>((a,b) -> b - a);
        helper(root,k);
        return pq.peek();
    }

    private void helper(TreeNode root, int k) {
        if(root == null) return;
        helper(root.left,k);
        pq.add(root.val);
        if(pq.size() > k) {
            pq.poll();
        }
        helper(root.right,k);
    }
}


// Iterative inorder traversal
// TC: O(n)
// SC: O(n) in worst case of skewed binary tree (all nodes to to left or right of root)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        int count = 0;

        // Iterative inorder traversal
        while(curr!= null || !st.isEmpty()) {
            while(curr!= null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            count++;
            if(count == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}