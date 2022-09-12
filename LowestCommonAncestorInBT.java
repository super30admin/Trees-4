public class LowestCommonAncestorInBT {
      //Ancestor of a node is node itself
         //Lowest means lowest in the level
         //Distance between 2 nodes can also be found out using LCA
         //if you know LCA you can find the distance between 2 nodes using LCA
         //Naive Approch:
         //Fill 2 path arraysusing backtracking
         //path1[] and path2[]: Traverse tree twice
         //you simply need to traverse both the arrays
         //last common node that you see is you LCS
         //we visit the root node and we recursively visit left and right nodes
         
         //2nd Approch:
         //Both nodes have to exist
         //1st case: if we find any of the two node first we return it since this would be the LCA 
         //2nd case: Only LCA will have have left node as p and right node as q, all other nodes p and q are present on one side
         //3rd case: if one the subtrees contains both n1 and n2, return the subtree which contains both
         //4th case: if none of its subtrees contain n1 and n2 we return null
         //Time:O(n)
        //Space: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
         //if we find any of the two node first we return it since this would be the LCA 
         if(root.val==p.val || root.val==q.val)
             return root;
         TreeNode lca1=lowestCommonAncestor(root.left,p,q);
         TreeNode lca2=lowestCommonAncestor(root.right,p,q);
         //2nd case: return root of node whose right and left are lca1 and lca2
         if(lca1!=null && lca2!=null)
             return root;
         //if one subtree contains both 
         if(lca1!=null)
             return lca1;
         return lca2;
         
     }
    
}
