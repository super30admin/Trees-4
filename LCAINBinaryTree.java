package Trees4;

public class LCAINBinaryTree {

	//TC : o(n)
	//SC : o(h)
	//Approach : Take paths of p and q and compare each elements and return previous node where p and q are breached. When path changes, it can be handled by backracking or making a copy of list. 
	//Backtracking is a better approach, because making copy of a list needs new list to be created every time
	class Solution {
	    List<TreeNode> path1;
	    List<TreeNode> path2;
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        path1 = new ArrayList<>();
	        path2 = new ArrayList<>();
	        backtrack(root, p, q, new ArrayList<>());
	        //iterate through any of the paths and return one before where p and q are not same
	        for(int i=0 ;i<path2.size(); i++){
	            if(path1.get(i)!=path2.get(i))
	                return path2.get(i-1);
	        }
	        return null;
	    }
	    
	    private void backtrack(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path){
	        //base
	        if(root == null) return;
	        
	        if(root == p){
	            path1 = new ArrayList<>(path);
	            path1.add(p);
	            path1.add(p);
	        }
	        if(root == q){
	            path2 = new ArrayList<>(path);
	            path2.add(q);
	            path2.add(q);
	        }        
	        
	        //logic
	        //action
	        path.add(root);
	        backtrack(root.left, p, q, path);
	        backtrack(root.right, p, q, path);
	        path.remove(path.size()-1);
	    }
	}
}
