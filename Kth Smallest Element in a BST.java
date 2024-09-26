// Time Complexity : O(H+K) 
WHERE H is height of the tree which means O(log N+K) for a balanced tree and O(N+K) for a skewed tree

// Space Complexity :O(H+K) 
WHERE H is height of the tree which means O(log N+K) for a balanced tree and O(N+K) for a skewed tree

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


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

//ITERATIVE
class Solution {
    public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> stack=new Stack<>();
        TreeNode cursor=root;
        while(cursor !=null)
        {
            stack.push(cursor);
            cursor=cursor.left;
        }
        
        while(!stack.isEmpty()){
            cursor =stack.pop();
            k--;
            if(k ==0) return cursor.val;
            
            if(cursor.right!=null){
             cursor=cursor.right;
             while(cursor !=null)
            {
            stack.push(cursor);
            cursor=cursor.left;
            }  
            }
        }
        return 0;
    }
}



// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES

//RECURSION
// class Solution {
//     ArrayList<Integer> arr=new ArrayList<>();
    
//     public int kthSmallest(TreeNode root, int k) {
//         inorder(root);
//         return arr.get(k-1);
//     }
//     public void inorder(TreeNode node){
//         if(node ==null){
//            return;
//         }
//         inorder(node.left);
//         System.out.println(node.val);
//         arr.add(node.val);
//         inorder(node.right);
//     }
// }