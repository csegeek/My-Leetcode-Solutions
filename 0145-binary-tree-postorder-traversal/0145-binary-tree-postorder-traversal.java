/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //using single stack
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        TreeNode lastVisited=null;
        while(curr !=null || !st.isEmpty()){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            else{
                TreeNode peek=st.peek();
                if(peek.right !=null && peek.right!=lastVisited){
                    curr=peek.right;
                }
                else{
                    res.add(peek.val);
                    lastVisited=st.pop();
                }
            }
        }
        return res;
    }

}