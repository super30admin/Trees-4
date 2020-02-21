//TC - O(log(n))
//SC - O(h)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode dummy = root;
        
        List<TreeNode> li1 = new ArrayList<>();
        List<TreeNode> li2 = new ArrayList<>();
        
        while(true)
        {
            li1.add(dummy);
            
            if(p == dummy) break;
            else if(p.val > dummy.val)
                dummy = dummy.right;
            else if(p.val < dummy.val)
                dummy = dummy.left;
        }
        
        dummy = root;
        
        while(true)
        {
            li2.add(dummy);
            
            if(q.val == dummy.val) 
                break;
            
            else if(q.val > dummy.val)
                dummy = dummy.right;
            else if(q.val < dummy.val)
                dummy = dummy.left;
        }
        
        int l = Math.min(li1.size(), li2.size());
        int i = 0;
        
        while(i < l)
        {
            if(li1.get(i) == li2.get(i))
                ++i;
            else
                break;
        }
        
        if(li1.size() >= li2.size())
            return li1.get(i-1);
        return li2.get(i-1);
    }
}
