


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

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope


// Your code here along with comments explaining your approach
/*Approach
1) we have to find the Kth smallest element in Binary search Tree, thus we can carry out inorder traversal thus we do not need to traverse the entire tree. we can go until k==0 or counter==k. Thus we can avoid the traversing the whole tree
2) Worst case would be if K == number of nodes in tree.
3) we carry out inroder traversal as inorder traversal will give us elements in ascending order, and we can stop at Kth smallest as stack will have all lower values in stack and we initiate pop calls before pushing node to node.right
-> at that time we can see if counter == k and if yes we just return the element popped from stack
4) while(!stack.isEmpty() || node!=null) is necessary as if node is null and stack is not empty we cannot get elements out of stack if the cndition would have been just while(node!=null)
5) while(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
    -> to push all left node in stack



*/

import java.util.*;
class KthSmallestElelementInBST {

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




    public int kthSmallest(TreeNode root, int k) {
        
        if(root==null)
        {
            return 0;
        }
        
        
       int counter=0;
       TreeNode node = root;
        Stack<TreeNode> stack = new Stack();
        
        while(!stack.isEmpty() || node!=null)
        {
            while(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
            
            node = stack.pop();
            counter++;
            if(counter==k)
            {
                return node.val;
            }
            node=node.right;
        }
        return -1;
        
    }
}

