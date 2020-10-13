// Time Complexity : O(n) 
// Space Complexity : O(max depth), max nodes at a time in stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Inorder of BST gives a sorted order, we can use this property
//we can pop the elements k times and when our count reaches k, popped value is our kth smallest element in BST
//implemented inorder using iterative approach(stack)

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) {
            return -1;
        }
        
        Stack<TreeNode> res=new Stack<>();
        int count=0;
        
        while(!res.isEmpty()||root!=null){
            while(root!=null){
                res.push(root);
                root=root.left;
            }
            TreeNode popped=res.pop();
            count+=1;
            if(count==k){
                return popped.val;
            }
            root=popped.right;
        }
        return -1;
    }
}