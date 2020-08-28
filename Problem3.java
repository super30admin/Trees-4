// There are three approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;

// Your code here along with comments explaining your approach
// Approach 1: Using DFS with backtracking to find path of two nodes
// Time Complexity :O(2*(n + h) + h) = O(n+h)
//      n: elements of tree
//      h: height of the tree
//  For both paths, Worst case we need to iterate all the elements
//      And we need add path to result that height of the tree
//    Also iterate O(h) to find leat common
// Space Complexity :O(2*(2h))= O(h)
//      h: height of the tree
// For both paths, 2h is the recursive and path
class Problem3S1 {
    // Definition for a binary tree node.
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

    /** fins lowest common ancestor */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // find path for p
        List<TreeNode> path1 =new ArrayList<>();
        dfsBackTrack(root, p, new ArrayList<>(), path1);

        // find path for q
        List<TreeNode> path2 =new ArrayList<>();
        dfsBackTrack(root, q, new ArrayList<>(), path2);

        // take min of both path
        int size = Math.min(path1.size(), path2.size());

        // iterate on both path
        int i = 0;
        while(i< size){
            if(path1.get(i) != path2.get(i))
                break;
            i++;
        }
        // takes care of out of bounds as well as value not equal
        return path1.get(i-1);   
    }
    
    /** DFS traversal with BackTracking helper */
    private void dfsBackTrack(TreeNode root, TreeNode target, List<TreeNode> path, List<TreeNode> result){

        // base case 0
        if(root == null)
            return;

        // base case 1
        if(root== target){
            for(TreeNode element:path)
                result.add(element);
            result.add(root);
            return;
        }
        
        // 1. Action
        path.add(root);

        // 2. Recurse

        dfsBackTrack(root.left, target, path, result);
        //  check target already found
        if(result.size() != 0)
            return;
        dfsBackTrack(root.right, target, path, result);
        //  check target already found
        if(result.size() != 0)
            return;

        // 3. BackTrack
        path.remove(path.size()-1);    
    }
}
// Your code here along with comments explaining your approach
// Approach 2: Using DFS return type boolean
// Any root where left path has p and right path has q (vice-versa) is least common ancestor
// Time Complexity :O(h) = O(h)
//      n: elements of tree
//      h: height of the tree
//  Worst case would be all n elemenst traversed
//   
// Space Complexity :O(h)
//      h: height of the tree
//  Recursive stack space
class Problem3S2 {
    // Definition for a binary tree node.
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

    // global result
    TreeNode resultNode;

    /** find lowest common ancestor */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // dfs
        dfs(root,p,q);

        // return result;
        return resultNode;
    }

    /** Depth First Travsersal  by updating result*/
    private boolean dfs(TreeNode root,TreeNode p, TreeNode q)
    {
        // default value
        boolean result=false;

        // base case
        if(root == null)
        {
            result = false;
        }
        else
        {
            // check root is p or q
            if(root == p || root == q)
                result = true;
            // check in left-subtree
            boolean left = dfs(root.left,p,q);
            // check in right-subtree
            boolean right = dfs(root.right,p,q);

            // check result with left and right p or q found
            if(result && left || result && right || left && right){
                resultNode = root;
                result = false; // return false as we need to add result once
            // either path found p or q
            }else if(left || right){ 
                result = true;  
            }
        }
        // return result
        return result;
    }
}
// Your code here along with comments explaining your approach
// Approach 3: Using DFS return type int
// Any root where left path has p and right path has q (vice-versa) is least common ancestor
// Time Complexity :O(h) = O(h)
//      n: elements of tree
//      h: height of the tree
//  Worst case we traverse all h elements 
// Space Complexity :O(h)
//      h: height of the tree
//  Recursive stack space
class Problem3S3 {
    // Definition for a binary tree node.
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
    // global result
    TreeNode resultNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // dfs traversal
        dfs(root,p,q);
        // return result
        return resultNode;
    }

    /** DFS traversal
     * Returns 0 if not found
     * Returns 1 if one is found
     * Returns -1 if both are found
     */
    private int dfs(TreeNode root,TreeNode p, TreeNode q)
    {
        // defult value
        int result=0;
        // base case
        if(root == null)
        {   
            return result;
        }
        else
        {
            int temp;
            //check root is p or q
            if(root == p || root == q)
                result = 1;
            
            // check left
            temp = dfs(root.left,p,q);
            // already found
            if(temp == -1)
                return temp;

            result += temp;

            // check right
            temp = dfs(root.right,p,q);

            // already found
            if(temp == -1)
                return temp;
            result += temp;

            // found by root, left, right combination
            if(result == 2){
                resultNode = root;
                result = -1; // found
            }
        }
        return result;
    }
}