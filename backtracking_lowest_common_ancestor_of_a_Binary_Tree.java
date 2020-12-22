// Time Complexity :O(n) where n is the size of the tree (exactly O(3n), 2n to find p and q and 1n to compare the paths pf p and q)
// Space Complexity :O(n) + O (h) = O(n), where n is the size of and h is the height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

//three liner explanation of your code in plain english
//1. Start DFS at root and keep adding current root to the path(list). once you reach null check if the last node in the list is 
        //equal to the child, if yes the then return OR move to the next step(exploring right subtree)
//2. After exploring right subtree, again check if the last node in the list is not the child, if yes return OR move forward to the
        //next step (backtrack), i.e remove the last node in the list
//3. This way find the paths for both p and q seperately in a seperate list and compare the nodes of the 2 list to be unequal, wherever
        //they become unequal, a node just previous is the LCA

// Your code here along with comments explaining your approach

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
    //to calculate the paths of p and q respecyively in the tree
    List<TreeNode> path1;
    List<TreeNode> path2;
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //edge case
        
        //initialise the path1 and path2
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        
        //recursive function to calculate path1 and path2
        backTrack(root, p, path1);
        backTrack(root, q, path2);
        //iterate over the 2 paths, and wherever they become unequal, return their previous node as the LCA
        int i=0;
        while(i<path1.size() && i<path2.size()){
            if(i>0 && path1.get(i) != path2.get(i)){
                return path1.get(i-1);
            }
            result = path1.get(i);
            i++;
        }
        return result;
    }
    
    //function to calculate the path1 and path2
    public void backTrack(TreeNode root, TreeNode child, List<TreeNode> path){
        //base
        if(root == null) return;
        //logic
        //action
        path.add(root);
        //recursion
        //go to left
        backTrack(root.left, child, path);
        //if the last node in the path is the child, then you dont want to explore the tree further
        if(path.get(path.size()-1) == child) return;
        //go to right
        backTrack(root.right, child, path);
        //if the last node in the path is the child, then you dont want to explore the tree further
        if(path.get(path.size()-1) == child) return;
        //backtrack
        path.remove(path.size()-1);
    }
}