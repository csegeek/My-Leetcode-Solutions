class Solution {
    public int largestRectangleArea(int[] heights) {
      int[] nsei=nsei(heights);
      int[] psei=psei(heights);
      //System.out.println("nsei-->"+Arrays.toString(nsei));
      //System.out.println("psei-->"+Arrays.toString(psei));
      int maxArea=Integer.MIN_VALUE;
      for(int i=0;i<heights.length;i++){
        int area=heights[i]*(nsei[i]-psei[i]-1);
        maxArea=Math.max(area,maxArea);
      }  
      return maxArea;
    }
    private int[] nsei(int[] heights){
        int n=heights.length;
        int[] res=new int [n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
           while(!st.isEmpty() && heights[st.peek()]>=heights[i])        {
            st.pop();
           }
           if(st.isEmpty()){
            res[i]=n;
           }
           else{
             res[i]=st.peek();
           }
           st.push(i);
        }
        return res;
    }

    private int [] psei(int[] heights){
        int n=heights.length;
        int[] res=new int [n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
           while(!st.isEmpty() && heights[st.peek()]>=heights[i])        {
            st.pop();
           }
           if(st.isEmpty()){
            res[i]=-1;
           }
           else{
             res[i]=st.peek();
           }
           st.push(i);
        }

        return res;
    }



}