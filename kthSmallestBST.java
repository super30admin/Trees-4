//Problem:101- Kth Smallest Element in a BST
//TC:O(N)
//SC:O(H), height of recursive stack

/*Steps
     1) Bruteforce : TC:O(N) | SC:O(N)
        As its is a BST, do the inorder traversal, which will give all elements in the ascending order and insert all elements in the list.Finally Return the k-1 element from the list.
     
     2) Optimized : 
        1) DFS : Initialize a global count. Use the concept of inorder traversal, Just like adding the root value, here increment the count. Once count is equal to k add it to the result and return;   
        2) Can be done iterative too.
     
*/
class Solution101 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int count;
    int result=-1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        
        helper(root,k);
        return result;
    }
    
    private void helper(TreeNode root, int k){
        
        if(root==null) return;
        
        if(result==-1){//if result not found then only traverse other nodes
           
            helper(root.left,k);
            count++;

            if(count==k){
                result = root.val;
                return;
            }

            helper(root.right,k);

        }
        
    }

    //Iterative
    /*
       Stack<TreeNode> stack = new Stack<>();
       while(root!=null || !stack.isEmpty()){
           while(root!=null){
               stack.push(root);
               root = root.left;
           }
            
            root = stack.pop();
            k--;
            
            if(k==0) return root.val;
            
            root = root.right;
            
        }

    */

    
    
    /* Bruteforce
    private List<Integer> result;
    public int kthSmallest(TreeNode root, int k) {
     //TC:O(N),SC:O(N), number of nodes in tree
        if(root==null) return 0;
        result = new ArrayList<>();
        
        helper(root);
        return result.get(k-1);
    }
    
    private void helper(TreeNode root){
        
        if(root==null) return ;
        
        helper(root.left);
        result.add(root.val);
        helper(root.right);
    }*/
}