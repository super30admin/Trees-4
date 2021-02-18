import java.util.LinkedList;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class KthSmallestElementInABst {
    /**
     * Definition for a binary tree node.
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> linkedList = new LinkedList<>();//create stack using linked list

            //inorder traversal of BST
            while(!linkedList.isEmpty() || root != null){
                while(root != null){
                    linkedList.add(root);
                    root = root.left;
                }
                root = linkedList.removeLast();
                if(--k == 0) return root.val;//optimize it to run less by checking if the kth value has been found
                root = root.right;
            }
            return -1;//return a value
        }
    }



}
