class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int sum=0;
        int[] nse=findNse(arr);
        int[] pres=findPres(arr);
        for(int i=0;i<arr.length;i++){
            int left = i - pres[i];
            int right = nse[i] - i;
            long freq = left * right * 1L;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum%mod;
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
}