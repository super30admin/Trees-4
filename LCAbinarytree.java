/*
TC: O(N) since we visit all nodes in worst case. As it is not binary search tree, we cannot reduce search space.
SC: O(N)

1. If root is either p or q, we return root.
2. Else, find p in left subtree. 
3. On finding p or q, we return the node. Else, we return null.
4. If both left and right subtree are not null, then we found LCA.
5. If either left or right != null then return left or right. 

*/


public class LCAbinarytree {
    TreeNode LCA;
    public TreeNode lcaRecursion(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
        
    }
    
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        
        if(LCA != null) return null;
        if(node == null) return null;
        System.out.println(node.val);
        if(p.val == node.val || q.val == node.val) return node;
        
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        
        if(left != null && right != null) {
            LCA = node;
            return LCA;
        }
        else if(left != null) return left;
        else return right;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        LCAbinarytree bt = new LCAbinarytree();

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(6);
        
        System.out.println(bt.lcaRecursion(root, p, q).val);

    }
}
