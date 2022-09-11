//Approach - 1:  Recursion, Inorder and decrement count=k 
//Time Complexity : o(n)
//Space Complexity : O(h)
class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        count = k;
        //Inoder L root R
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
    //base
    if(root == null) return;
    
    //logic
    inorder(root.left);
    System.out.println(root.val);
    count --;
    if(count == 0){
        result = root.val;
        return;
    }     
    inorder(root.right);
    }
 
}

//Approach - 2:  Conditinal Recursive calls, Inorder and decrement count=k 
//Time Complexity : o(n)
//Space Complexity : O(h)
class Solution {
    int count;
    int result;
    boolean flag;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        count = k;
        //Inoder L root R
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root){
    //base
    if(root == null) return;
    
    //logic
    if(!flag)
     inorder(root.left);
    System.out.println(root.val);
    count --;
    if(count == 0){
        flag = true;
        result = root.val;
        return;
    } 
    if(!flag)
     inorder(root.right);
    }
 
}

