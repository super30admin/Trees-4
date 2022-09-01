// approch 1
// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Main {

    // approch 1 using priority Queue
    private static PriorityQueue<Integer> pq;

    public static int kthSmallest(TreeNode root, int k) {
        // max heap
        pq = new PriorityQueue<>((a, b) -> b - a);
        // dfs traversal
        dfs(root, k);
        return pq.peek();
    }

    // dfs traversal of the tree
    private static void dfs(TreeNode root, int k) {
        // base case
        if (root == null)
            return;
        // main logic
        // add value inside the pq
        pq.add(root.val);
        // if pq size is greater than the k
        // poll from the queue
        if (pq.size() > k) {
            pq.poll();
        }
        dfs(root.left, k);
        dfs(root.right, k);
    }

    // approch 2 by maintaining the count
    private static int count;
    private static int result;

    public static int kthSmallest2(TreeNode root, int k) {
        count = 0;
        result = 0;
        // dfs traversal
        dfs2(root, k);
        return result;
    }

    // dfs inorder traversal of the tree
    private static void dfs2(TreeNode root, int k) {
        // base case
        if (root == null)
            return;

        dfs(root.left, k);
        // increase the count
        count++;
        // when count = k we store the result and return
        if (count == k) {
            result = root.val;
            return;
        }
        dfs(root.right, k);
    }

    public static void main(String[] args) {

    }
}