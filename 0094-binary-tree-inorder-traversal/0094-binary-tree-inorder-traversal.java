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
    // public List<Integer> inorderTraversal(TreeNode root) {
        
    // }

public List<Integer> inorderTraversal(TreeNode root) {
    if(root==null) return new ArrayList<>();
    Stack<Pair> st=new Stack<>();
    List<Integer> preOrder=new ArrayList<>();
    List<Integer> inOrder=new ArrayList<>();
    List<Integer> postOrder=new ArrayList<>();
    st.push(new Pair(root,1));
    while(!st.isEmpty()){
        Pair itr=st.pop();
        if(itr.num==1){
            preOrder.add(itr.node.val);
            itr.num++;
            st.push(itr);
            if(itr.node.left!=null){
                st.push(new Pair(itr.node.left,1));
            }
        }
        else if(itr.num==2){
            inOrder.add(itr.node.val);
            itr.num++;
            st.push(itr);
            if(itr.node.right!=null){
                st.push(new Pair(itr.node.right,1));
            }
        }
        else{
            postOrder.add(itr.node.val);
        }
    }
   return inOrder;
}

class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
}

    
}