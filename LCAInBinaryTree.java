import java.util.ArrayList;
import java.util.List;

// Time is O(N)
//Space is O(N)we use two list 
public class LCAInBinaryTree {
	  
    TreeNode result;
    boolean found;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode>  qList = new ArrayList<>();
       
        helper(root,p,pList);
        found = false;
        helper(root,q,qList);
        
        int n= qList.size();
        
        for(int i=n-1;i>=0;i--){
            if(pList.contains(qList.get(i)))
               return qList.get(i);
        }
        
        return result;
    }
    
    public void helper(TreeNode root,TreeNode p,List<TreeNode> list){
        // base condition
        if(root==null || this.found)
            return;
        if(root == p)
        {
        list.add(root);
        this.found=true;
        }    
        // logic
        list.add(root);
        helper(root.left,p,list);
        helper(root.right,p,list);  
        if(this.found!=true)
            list.remove(list.size()-1);
    }
    
}
