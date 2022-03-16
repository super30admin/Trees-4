class Solution {
    TreeNode p; TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p= p;
        this.q= q;
        return helper(root);    
    }
    private TreeNode helper(TreeNode root){
        if(root== null) return null;
        if(root == p) return p;
        if(root == q) return q;
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left!= null && right!= null) return root;
        else if(left!= null && right== null) return left;
        else if(right!= null && left== null) return right;
        
        
        return null;
    }
}
//time complexity- O(n)
//space complexity- O(n)

//iterative

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         Stack<TreeNode> stack = new Stack<>();
         Map<TreeNode, TreeNode> parent = new HashMap<>();  
         parent.put(root, null);
        stack.push(root);
      
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node= stack.pop();
             if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
     
         Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
            
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}

//time complexity- O(n)
//space complexity- O(n)