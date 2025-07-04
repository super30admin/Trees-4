/*
 Approach 1- Path finidng Algo
 We can find path for every node via brute force recursion or backtracking
 Time complexity - O(N) sice we are visiting all nodes
 Space complexity - O(H) recursive stack as well as storing path in list
 Recusrion stack O(H) can O(logN) in case of perfect tree
 and O(H) will change to O(N) in skewed tree. for simplicity we say space complexity is O(H)

 Did this code successfully run on Leetcode :  Yes
 Any problem you faced while coding this :  No
*/

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfBinaryTree_LC_236 {
    List<TreeNode> pPath;
    List<TreeNode> qPath; //if you initialize to new ArrayList in below method you will get null answer
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        dfs(root, p, q, new ArrayList<>());
        //Process list p and q
        for(int i = 0; i<pPath.size(); i++) {
            if(pPath.get(i) != qPath.get(i))
                return pPath.get(i-1); //if current node is not matching last matched node is LCA
        }
        return null;
    }

    private void dfs(TreeNode root,TreeNode p, TreeNode q, List<TreeNode> path) {
        //base case
        if(root == null) return;

        //Void based Conditional recursion to save some space of recursive stack
        if(pPath != null && qPath != null) return; //do not initialize pPath and qPath to new ArrayList or it will return null for all test cases.

        //logic
        path.add(root);

        dfs(root.left, p, q,path);
        dfs(root.right, p, q, path);

        if(root == p){ //add this path to list PPath
            pPath = new ArrayList<>(path);
            pPath.add(root); // we added this to take care of mismatch scenario where list p and   list p are not of same size in that case it will be difficult to check lcs
        }
        if(root == q){ //add this path to list qPath
            qPath = new ArrayList<>(path);
            qPath.add(root); // we added this to take care of mismatch scenario where list p and   list p are not of same size in that case it will be difficult to check lcs
        }
        path.remove(path.size()-1);

    }
}

/*
Approach 2: Bottom up recursion

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null;
        else if(left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return root;
    }
}
*/