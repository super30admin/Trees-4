// Time Complexity : O(H+k) H height of tree, k is the number of nodes to be processed until we reach 1.
// Space Complexity : O(H+k), O(N+k) in worst case. Worst case k can be equivalent to the total number of nodes, O(Log N + k) is average case.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach


//Iterative approach
class Solution {
    //do an inorder traversal
    //keep track of kth smallest
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null) return 0; // ask interviewer
        
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        
        //try to traverse the tree iteratively for inorder
        while(curr != null || !s.isEmpty()){
            
            //traverse left side first
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            
            //pop elements from stack to add to result array
           curr = s.pop();
            if(k == 1){
                return curr.val;
            }else{
                k--;
            }
            
            curr = curr.right; //traverse the right side
            
        }        
        return 0;
        
    }
}


//Recursive version

class Solution {
//T: O(N) because we need to iterate through the whole Tree, then return the list
    //S: O(N) recursive call stack
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        List<Integer> res = new LinkedList<>();
         helper(root, res);
        return res.get(k-1);
    }
    
    private void helper(TreeNode node, List<Integer> res){
     
        if(node.left != null)
            helper(node.left, res);
    
        res.add(node.val);

        if(node.right != null)
            helper(node.right, res);
    }
}