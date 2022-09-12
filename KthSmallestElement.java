class Solution {

    //Inorder traversal in a BST gives elements in sorted order
    //We can maintain a count and whenever it becomes equal to k we return
    // Why we have count as global because if we send count as an argument it would be become local to the recursion
    //Optimization: Condition Recursion: Only Recur if element is not yet found

    int count=0;
    int rootVal=Integer.MIN_VALUE;
    boolean flag; 
    public int kthSmallest(TreeNode root, int k) {
    
        if(root==null||k==0)
            return -1;
       findSmallest(root,k);
        
        return rootVal;
     
       
    }
    
    public void findSmallest(TreeNode root, int k)
    {
        if(root==null)
            return;
        
          if(!flag) 
           findSmallest(root.left,k);
            count++;
            if(count==k)
            {
                flag = true;
                rootVal=root.val;
            }   
            if(!flag)
             findSmallest(root.right,k);
        
        
        return;
    }
    
     
}