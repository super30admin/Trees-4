// Time Complexity : O(n)
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
 // Do inorder trvaersal and keep track of the count of nodes visited
// Once count reaches k, store the node in result and return


//Lowest Common Ancestor of a Binary Search Tree
 // Time Complexity : O(h) where h is the height of the tree
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// how to move the root node according to the values of p and q
// Your code here along with comments explaining your approach
// if p and q are less than root, move to left subtree
// if p and q are greater than root, move to right subtree
// else return root

// Time Complexity : O(n)
// Space Complexity :O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// adding the path
// Your code here along with comments explaining your approach
// Do a backtrack to find the path from root to p and root to q
// then compare the paths to find the first different node
//      return the previous node as the LCA