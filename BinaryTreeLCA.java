// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pPath;
    List<TreeNode> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helperDfsBottomUp(root, p, q);

        // helperDfs(root, p, q, new ArrayList<>());
        
        // helperBfs(root, p, q);

        // for (int i = 0; i < pPath.size(); i++) {
        //     if (pPath.get(i) != qPath.get(i)) {
        //         return pPath.get(i - 1);
        //     }
        // }
        // return null;

    }

    private void helperBfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        List<TreeNode> path = new ArrayList<>();
        path.add(root);
        Queue<List<TreeNode>> pathQ = new LinkedList<>();
        pathQ.offer(path);

        while (!Q.isEmpty()) {
            TreeNode currNode = Q.poll();
            List<TreeNode> currPath = pathQ.poll();

            if (currNode == p) {
                currPath.add(currNode);
                pPath = new ArrayList<>(currPath);
                currPath.remove(currPath.size() - 1);
            }

            if (currNode == q) {
                currPath.add(currNode);
                qPath = new ArrayList<>(currPath);
                currPath.remove(currPath.size() - 1);
            }

            if (pPath != null && qPath != null) {
                return;
            }

            if (currNode.left != null) {
                Q.offer(currNode.left);
                currPath.add(currNode.left);
                pathQ.offer(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }

            if (currNode.right != null) {
                Q.offer(currNode.right);
                currPath.add(currNode.right);
                pathQ.offer(new ArrayList<>(currPath));
                currPath.remove(currPath.size() - 1);
            }

        }
    }

    private void helperDfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if (root == null) {
            return;
        }

        path.add(root);
        if (root == p) {
            path.add(root);
            pPath = new ArrayList<>(path);
            path.remove(path.size() - 1);
        }

        if (root == q) {
            path.add(root);
            qPath = new ArrayList<>(path);
            path.remove(path.size() - 1);
        }

        if (pPath == null || qPath == null) {
            helperDfs(root.left, p, q, path);
            helperDfs(root.right, p, q, path);
        }

        path.remove(path.size() - 1);

    }

    private TreeNode helperDfsBottomUp(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = helperDfsBottomUp(root.left, p, q);
        TreeNode right = helperDfsBottomUp(root.right, p, q);

        if (right == null && left == null) {
            return null;
        } else if (right == null && left != null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else {
            return root;
        }

    }
}