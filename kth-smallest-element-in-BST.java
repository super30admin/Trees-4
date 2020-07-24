/*
Time Complexity : O(n)    n-number of nodes
Space Complexity : O(h)   h-Height of tree
*/

//Iterative Solution
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st=new Stack<>();
        
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            k--;
            if(k==0){
                return root.val;
            }
            root=root.right;
        }
        return -1;
    }
}



//Recursive Solution
//Recursive Solution
class Solution{
    int count; int result;
    public int kthSmallest(TreeNode root, int k){
        count=k;
        inorder(root);
        return result;
    }
    public void inorder(TreeNode root){
        //base
        if(root==null){
            return;
        }
        inorder(root.left);
        count--;
        if(count==0){
            result=root.val;
            return;
        }
        
        inorder(root.right);
    }
}