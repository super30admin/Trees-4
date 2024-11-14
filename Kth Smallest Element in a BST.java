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


 //inorder traversal then find kth smallest element tc- O(n)
 //when using heap -tc - O(nlogk )
// class Solution {
//     int count;
//     int result = 0;
//     public int kthSmallest(TreeNode root, int k) {
//         this.count = 0;
//         helper(root, k);
//         return result;     
//     }
//     private void helper(TreeNode root, int k){
//         //base
//         if(root == null) return;

//         //logic
//         if(count <= k){//it will stop recurssion when we have found kth ele
//            helper(root.left, k);
//         } 
//         count++;
//         if(count == k){
//             this.result = root.val;
//             return;
//         }
//         if(count <= k){
//            helper(root.right, k);
//         }

//     }
// }


//iterative approach for inorder
class Solution {
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root != null){
            while(root!=null){
                st.push(root);
                root = root.left;
            }

            root = st.pop();

            k--;
            if(k == 0) return root.val;

            root = root.right;
        }

        return -1;
          
    }
    
}

//follow up:
//we can assign num of left nodes of that node at each node, it will be logarithmic