class MinStack {
     Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
        }
        else{
            int currMin=Math.min(val,st.peek().currMin);
            st.push(new Pair(val,currMin));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
       return st.peek().val;
    }
    
    public int getMin() {
       return st.peek().currMin;
    }
}

class Pair{
    int val;
    int currMin;
    Pair(int val,int currMin){
       this.val=val;
       this.currMin=currMin;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */