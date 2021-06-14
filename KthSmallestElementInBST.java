//Time: O(n) where n = number of nodes
//Space: O(h) where h = height of tree
//Did it run on leetcode: yes
class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        //stack to store TreeNode
        Stack<TreeNode> st = new Stack<>();
        //variable keep track of current smallest number
        int count=0;
        //until root is not null or stack is not empty
        while(root!=null || !st.isEmpty()){
            //until root is not null
            while(root!=null){
                //push root in stack
                st.push(root);
                //leep moving root to left until left most is reached
                root = root.left;
            }
            //now root is null, get the previous node
            root = st.pop();
            //count the current number of smallest node
            count++;
            // if count is equal to k, return value of root
            if(count == k) return root.val;
            //move root to right node
            root = root.right;
        }
        return -1;
    }
}