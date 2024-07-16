
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/1323420163/
//LC:230

import java.util.Stack;

/**
 * public class TreeNode {
 * * int val;
 * * TreeNode left;
 * * TreeNode right;
 * * TreeNode() {}
 * * TreeNode(int val) { this.val = val; }
 * * TreeNode(int val, TreeNode left, TreeNode right) {
 * * this.val = val;
 * * this.left = left;
 * * this.right = right;
 * * }
 * * }
 */


public class KthSmallestElementInBST {

    //TIme complexity = o(n)
    // Space complexity o(n)

    //Iterative approach
    // Take the stack and keep pushing left toot  in to stack until left hits null.
    //then smallesst elemnt is hit as its BST. reduce k by 1.
    //start poping and  start going back up the left tree. after evry pop reducing k by 1.
    //When K has reached 0 we would be standing t the k1th smallest element. returns its val

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            k--;
            if (k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return root.val;
    }

    public class TreeNode {
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

    // Recursive function
    // Time complexity. o(k). we are traversing the K only s logn
    // as we find the k, once the answer is found ans set, we are returning.
    // Not travrsing n elements. only traversing k element
    // space complexity - o(h) recursive stack space
    int answer;
    int cnt;

    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        cnt = k;
        answer = -1;

        recurse(root);
        return answer;
    }

    private void recurse(TreeNode root) {
        if (root == null || answer != -1) {
            return;
        }
        recurse(root.left);
        cnt--;
        if (cnt == 0) {
            answer = root.val;
        }
        recurse(root.right);

    }


}
