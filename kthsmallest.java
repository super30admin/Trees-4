/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    ArrayList<Integer> ans= new ArrayList<>();
    int c;
    public int kthSmallest(TreeNode root, int k) {
        c=k;
        if (root==null)
            return 0;
        
        inOrder(root);
        return ans.get(k-1);
     
    }
    
    void inOrder(TreeNode root)
    {  
        if (root==null || ans.size()>c)
            return;
    
        inOrder(root.left);
        
      
        if (ans.size()<=c)
            ans.add(root.val);
        
        inOrder(root.right);
    }
}
