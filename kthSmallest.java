class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        findsmallest(root,list);
        return list.get(k-1);
    }
    public void findsmallest(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        findsmallest(root.left,list);
        list.add(root.val);
        findsmallest(root.right,list);
    }
}