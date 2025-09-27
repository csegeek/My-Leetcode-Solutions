class Solution {
    public boolean parseBoolExpr(String expression) {

        int i=0;
        Stack<Character> st=new Stack<>();
        while(i<expression.length()){
            if(expression.charAt(i)==',') { 
                i++;
                continue;
                }
            if(expression.charAt(i)!=')') st.push(expression.charAt(i));
            else{
                ArrayList<Character> list=new ArrayList<>();
                while(st.peek() !='('){
                 list.add(st.pop());
                }
                st.pop();
                boolean ans=evaluateExpression(st.pop(),list);
                st.push(ans==true ? 't':'f');
            }
         i++;
        }
        return st.pop()=='t'? true:false; 
    }

    boolean evaluateExpression(char operator,List<Character> operands){
    
        if(operator=='!'){
         return operands.get(0)=='t'? false:true; 
        }

        if(operator=='|'){
            boolean temp=operands.get(0)=='t'?true:false;
            for(int i=1;i<operands.size();i++){
                if(operands.get(i)=='t') temp=temp|true;
                if(operands.get(i)=='f') temp=temp|false;
            }
            return temp;
        }

        if(operator=='&'){
            boolean temp=operands.get(0)=='t'?true:false;
            for(int i=1;i<operands.size();i++){
                if(operands.get(i)=='t') temp=temp&true;
                if(operands.get(i)=='f') temp=temp&false;
            }
            return temp;
        }
        return true;
    }
}