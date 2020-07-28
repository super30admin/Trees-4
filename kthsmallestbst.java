//Time complexity:O(n)
//Space complexity:O(h)

public int kthSmallest(TreeNode root, int k) {
    int count=k;
    Stack<TreeNode> st=new Stack();
    while(!st.isEmpty() || root!=null){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        root=st.pop();
        count--;
        if(count==0){
            return root.val;
        }
        root=root.right;
    }
    return -1;
}