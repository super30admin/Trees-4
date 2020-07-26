// Time Complexity : O(n)- where n is the number of nodes in the tree.
// Space Complexity : O(h) or O(logn) - the stack space occupied is equal to the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach : Iterative approach using stack. Go lef left left , the pop and then reduce the k. If k =0 we got the answer. Other wise, do a root.right.

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            k=k-1;
            if(k==0) return root.val;
            root=root.right;
        }
        return -1;
    }
}

// Time Complexity : O(n)- where n is the number of nodes in the tree.
// Space Complexity : O(h) or O(logn) - the stack space occupied is equal to the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Recursive approach, inorder traveral.  base case is when the root is null.inorder(left) then decrement the k, if k =0 store the result and return. If the k is not zero, then go to root.right and check.

class Solution {
    int count=0;int result=0;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inorder(root);
        return result;
        }
    public void inorder(TreeNode root){
        //base
        if(root==null) return;
        //logic
        inorder(root.left);
        //st.pop()
        count=count-1;
        if(count==0){
            result=root.val;
            return;
        }
        inorder(root.right);
        
    }
    }