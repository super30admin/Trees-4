// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

// Time Complexity: O(N + min(M, N))
// Space Complexity: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> pathP;
    List<TreeNode> pathQ;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root.val > p.val && root.val > q.val ) return lowestCommonAncestor(root.left, p, q);
        // else if(root.val < p.val && root.val < q.val ) return lowestCommonAncestor(root.right, p, q);
        // else return root;
        this.pathP = new ArrayList<>();
        this.pathQ = new ArrayList<>();
        this.result = new TreeNode();
        if(root == null) return result;

        helper(root, p, q, new ArrayList<>());
        int i = 0;
        int j = 0;
        for(int k = 0; k < pathP.size(); k++) {
            System.out.println("pathP "+ pathP.get(k).val);
        }
        for(int k = 0; k < pathQ.size(); k++) {
            System.out.println("pathQ "+ pathQ.get(k).val);
        }
        while(i != pathP.size() && j != pathQ.size() ) {
            if(pathP.get(i) != pathQ.get(j)) {
                result = pathP.get(i - 1);
                break;
            }
            i++;
            j++;
        }
        return result;
    }

    private void helper(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
        //base
        if(root == null) return;

        //logic
        //action
        path.add(root);
        if(root == p) {
            pathP = new ArrayList<>(path);
            pathP.add(root);
        }
        if(root == q) {
            pathQ =  new ArrayList<>(path);
            pathQ.add(root);
        }

        //recurse
        helper(root.left, p, q, new ArrayList<>(path));
        helper(root.right, p, q, new ArrayList<>(path));

        //backtrack
        // path.remove(path.size() -1 );

    }
}