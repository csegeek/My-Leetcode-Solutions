class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<Character>();
        StringBuilder res=new StringBuilder("");
        for(char c:s.toCharArray()){
            if(c=='('){
                if(st.size()>0) res.append(c);
                st.push(c);
            }
            else{
              st.pop();
              if(st.size()>0) res.append(c);
            }
        }
        return res.toString();
    }

}