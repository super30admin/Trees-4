//Time complexity: O(N)
//Space Complexity: O(N)
//Accepted on leetcode
class Solution {
    //Initialise the result variable to min value.
    int result = Integer.MIN_VALUE;
    //Initialise counter and set to 0 
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        //Call traversal function for the root node and also pass the k value as argument
        traverse(root,k);
        //return result
        return result;
    }
    //Recursive function to find the k smallest val
    private void traverse(TreeNode root, int k)
    {
        //If the tree is empty
        if(root == null)
        {
            return;
        }
        //recursively call the function for all nodes on the left branch
        traverse(root.left,k);
        //Increment counter
        count++; 
        //If the count reaches k value
        if(count == k) 
        {
            //store the val at current node as the result
            result = root.val;
        }
        //recursively call function on the right 
        traverse(root.right,k);
    }
}