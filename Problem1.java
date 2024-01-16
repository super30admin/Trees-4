// Time Complexity : O(h)  where h=n in worst case
// Space Complexity : O(h) where h=n in worst case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

class Solution {
    private int count  = 0;
    private int kthSmallest = -1;
    public int kthSmallest(TreeNode root, int k) {

       helperRecursive(root , k);
       return kthSmallest;
       //return iterative(root, k);
    }
    // We will do In Order traversal ,
    private void helperRecursive(TreeNode node , int k){
        if(node == null){
            return;
        }
        if(count < k){ // This is to stop recursion when we find the element
            helperRecursive(node.left , k);
            count++; 
            if(count == k){
                // this is the kth smallest element
                kthSmallest = node.val;
            }
            helperRecursive(node.right , k);
        }
    }

    private int helperIterative(TreeNode root , int k){
        Stack<TreeNode> stack = new Stack<>();
        // Think of root as the pointer  
        //In order traversal
f the root is null, if the stack is not empty then we can always pop

        // Traverse left on the root
        while(root!=null){ // it will keep on traversing left until it finds the last node
            stack.push(root); // pust the root on the stack and then traverse left
            root = root.left;
        }
         root = stack.pop();// now the node is going to visit itself
         count++;
         if(count == k){ // this the value we were looknig for
         return root.val;
         }
         // traverse right
         root = root.right;
        }

        return -1; // unreachable anyways
    }

