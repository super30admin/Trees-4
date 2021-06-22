//Time Complexiy : O(n)
//Space Complexity : O(h). h is the height of the tree
class Solution {
    int val=0,count=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
       inorder(root,k);//inorder gives an ordered arrangement of the nodes in the increasing order of the nodes
        return val;
    }
    public void inorder(TreeNode root,int k){
        if(root==null || val!=0){//by using val!=0 all the nodes in the right are not checked. this is an optimization
            return;
        }
        inorder(root.left,k);
        //once all the nodes are visited in the lefy increase the count
        count++;
        //at each level check if it is equal to k
        if(count==k){
            //if so return the val
           val = root.val;
            return;
        }
        inorder(root.right,k);
    }
}
*/
//Iterative
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }
        int result=0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
             root = stack.pop();
            k--;
            if(k==0){
                result = root.val;
                return result;
            }
           
            root = root.right;
        }
        return result;
    }
}