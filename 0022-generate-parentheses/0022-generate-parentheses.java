class Solution {
    //solve without backtracking .
    public List<String> generateParenthesis(int n) {
      //same pattern as previous try to solve. 
      List<String> response=new ArrayList<>();
      StringBuilder s =new StringBuilder("");
      for(int i=0;i<2*n;i++){
        s.append("(");
      }
      recursiveParenthesis(response,s,0);
      return response;
      
    }

    private void recursiveParenthesis(List<String> response,StringBuilder s,int i){
        if(i>=s.length()){
            return ;
        }
        if(isValidParanthesis(s.toString())){
            System.out.println(s.toString());
            response.add(s.toString());
        }
        recursiveParenthesis(response,s,i+1);
         s.setCharAt(i,')');
          if(isValidParanthesis(s.toString())){
            System.out.println(s.toString());
            response.add(s.toString());
        }
        recursiveParenthesis(response,s,i+1);
        s.setCharAt(i,'(');
    }

    boolean isValidParanthesis(String s){
     Stack<Character> stack=new Stack<>();
     for(int i=0;i<s.length();i++){
      if(s.charAt(i)=='('){
        stack.push('(');
      }
      else if(s.charAt(i)==')' && !stack.isEmpty() ){
        stack.pop();
      }
       else if(s.charAt(i)==')' && stack.isEmpty() ){
       return false;
      }
     }
     if(stack.isEmpty()){
        return true;
     }
     else return false;

    }
}