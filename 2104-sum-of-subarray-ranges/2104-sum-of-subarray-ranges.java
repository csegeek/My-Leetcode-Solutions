class Solution {
    public long subArrayRanges(int[] arr) {  
        long sumMin=0;
        long sumMax=0;
        int[] nse=findNse(arr);
        int[] pres=findPres(arr);
        int[] nge=findNge(arr);
        int[] prge=findPrge(arr);

        for(int i=0;i<arr.length;i++){
            int left = i - pres[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            long val =freq * arr[i];
            sumMin = (sumMin + val);
        }
        
        for(int i=0;i<arr.length;i++){
            int left = i - prge[i];
            int right = nge[i] - i;
            long freq = left * right * 1L;
            long val = freq * arr[i];
            sumMax = (sumMax + val);
        }

        return sumMax-sumMin;

    }

    int[] findNse(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] response=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty()&& arr[i]<arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
                response[i]=arr.length;
            }
            else{
                response[i]=st.peek();  
            }
             st.push(i);
        }
        return response;
    }

    int[] findPres(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] response=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&& arr[i]<=arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
                response[i]=-1;
            }
            else{
                response[i]=st.peek();
            }
             st.push(i);
        } 
        return response;
        }
    
    int[] findNge(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] response=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty()&& arr[i]>arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
                response[i]=arr.length;
            }
            else{
                response[i]=st.peek();  
            }
             st.push(i);
        }
        return response;
    }

    int[] findPrge(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] response=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty()&& arr[i]>=arr[st.peek()]){
              st.pop();
            }
            if(st.isEmpty()){
                response[i]=-1;
            }
            else{
                response[i]=st.peek();
            }
             st.push(i);
        } 
        return response;
    }

}